package io.github.alexopa.democucumber.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.util.MimeTypeUtils;
import org.springframework.util.ResourceUtils;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.SerializationFeature;
import io.cucumber.java.Scenario;
import lombok.AllArgsConstructor;
import lombok.Data;

@Component
public class AttachmentUtil {

	private final ObjectMapper objectMapper = new ObjectMapper();

	private final static List<String> PRODUCT_NAMES = Arrays.asList("banana", "apple", "cucumber", "tomato",
			" lettuce");

	public AttachmentUtil() {
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
	}

	public void addAttachment(Scenario scenario) throws IOException {
		Collection<String> tags = scenario.getSourceTagNames();

		if (tags.contains("@attach-json")) {
			attachJson(scenario);
		}
		if (tags.contains("@attach-text")) {
			attachText(scenario);
		}
		if (tags.contains("@attach-image")) {
			attachImage(scenario);
		}
	}

	public void attachJson(Scenario scenario) throws JsonProcessingException {
		List<String> products = new ArrayList<>(PRODUCT_NAMES);
		Collections.shuffle(products);

		ThreadLocalRandom r = ThreadLocalRandom.current();

		List<Product> productsAttach = products.stream().limit(r.nextLong(1, products.size() + 1))
				.map(p -> new Product(p, r.nextInt(10))).collect(Collectors.toList());

		scenario.attach(objectMapper.writeValueAsBytes(productsAttach), MimeTypeUtils.APPLICATION_JSON_VALUE,
				"products-report");
	}

	public void attachText(Scenario scenario) {
		scenario.attach(String.format("Random uuid: %s", UUID.randomUUID().toString()), MimeTypeUtils.TEXT_PLAIN_VALUE,
				"Random UUID");
	}

	public void attachImage(Scenario scenario) throws IOException {
		File imagesFolder = ResourceUtils.getFile("classpath:images/");
		if (imagesFolder.isDirectory()) {
			File[] images = imagesFolder.listFiles();
			File imageToAttach = images[ThreadLocalRandom.current().nextInt(images.length)];
			byte[] byteArray = new byte[(int) imageToAttach.length()];
			try (FileInputStream inputStream = new FileInputStream(imageToAttach)) {
				inputStream.read(byteArray);
			}
			scenario.attach(byteArray, MimeTypeUtils.IMAGE_PNG_VALUE, imageToAttach.getName());
		}
	}

	@Data
	@AllArgsConstructor
	private class Product {
		private String name;
		private int quantity;
	}
}
