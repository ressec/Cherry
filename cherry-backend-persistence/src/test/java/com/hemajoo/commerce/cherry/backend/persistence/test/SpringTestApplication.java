/*
 * (C) Copyright Resse Christophe 2021 - All Rights Reserved
 * -----------------------------------------------------------------------------------------------
 * All information contained herein is, and remains the property of
 * Resse Christophe. and its suppliers, if any. The intellectual and technical
 * concepts contained herein are proprietary to Resse C. and its
 * suppliers and may be covered by U.S. and Foreign Patents, patents
 * in process, and are protected by trade secret or copyright law.
 *
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained from
 * Resse Christophe (christophe.resse@gmail.com).
 * -----------------------------------------------------------------------------------------------
 */
package com.hemajoo.commerce.cherry.backend.persistence.test;

import com.hemajoo.commerce.cherry.backend.persistence.configuration.PersistenceConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * A Spring boot test application.
 * @author <a href="mailto:christophe.resse@gmail.com">Christophe Resse</a>
 * @version 1.0.0
 */
@Import({ PersistenceConfiguration.class })
@ComponentScan(basePackages = "com.hemajoo.commerce.cherry.backend.persistence")
@EnableJpaRepositories(basePackages = "com.hemajoo.commerce.cherry.backend.persistence")
@EntityScan(basePackages = "com.hemajoo.commerce.cherry.persistence")
@SpringBootApplication
public class SpringTestApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(SpringTestApplication.class, args);
    }
}
