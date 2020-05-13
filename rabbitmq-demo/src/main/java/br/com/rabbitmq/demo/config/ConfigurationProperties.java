package br.com.rabbitmq.demo.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigurationProperties {

	private static final Logger LOGGER = LoggerFactory.getLogger(ConfigurationProperties.class);

	private Properties properties;
	private static final String propFileName = "configuration.properties";

	public ConfigurationProperties() {
		if (properties == null) {
			properties = new Properties();
			this.loadPropertyFile();
		}
	}

	public String getProperty(String key) {
		if (properties.containsKey(key)) {
			return properties.getProperty(key);
		}

		throw new RuntimeException("Property named " + key + " doesn't exist");
	}
	
	public void reloadProperties() {
		this.loadPropertyFile();
	}

	private void loadPropertyFile() {
		LOGGER.info("Loading '{}'", propFileName);

		InputStream stream = getClass().getClassLoader().getResourceAsStream(propFileName);

		if (stream != null) {

			try {
				properties.load(stream);
			} catch (final IOException e) {
				LOGGER.error("Error on trying to read property file. {}", e.getMessage());
			}
		}
	}

}
