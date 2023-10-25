package de.ait.template.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 10/25/2023
 * OnlineShop
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Configuration
@ConfigurationProperties(prefix = "s3")
@Data
public class S3ConfigurationProperties {

    private String accessKey;

    private String secretKey;

    private String endpoint;

    private String region;
}
