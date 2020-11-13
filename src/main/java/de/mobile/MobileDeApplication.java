package de.mobile;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.i18n.LocaleContextHolder;

import de.mobile.common.LocaleProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author Swarnava Chakraborty
 *
 */

@SpringBootApplication(scanBasePackages = "de.mobile.*")
@EnableSwagger2
public class MobileDeApplication {
	public static void main(String[] args) {
		SpringApplication.run(MobileDeApplication.class, args);
	}
	
	@Bean
	public LocaleProvider localeProvider() {
		return new LocaleProvider() {
			@Override
			public Locale get() {
				return LocaleContextHolder.getLocale();
			}
		};
	}
}
