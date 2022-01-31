package com.cb008101.pharmacyms.users.user.imageupload;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;


@Configuration
public class MvcConfig implements WebMvcConfigurer
{

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        String dirName = "user-photos";
        Path userPhotosDir = Paths.get(dirName);

        String userPhotosPath = userPhotosDir.toFile().getAbsolutePath();

        registry.addResourceHandler("/" + dirName + "/**")
                .addResourceLocations("file:/" + userPhotosPath + "/");
    }

//	private void exposeDirectory(String pathPattern, ResourceHandlerRegistry registry) {
//		Path path = Paths.get(pathPattern);
//		String absolutePath = path.toFile().getAbsolutePath();
//
//		String logicalPath = pathPattern.replace("../", "") + "/**";
//
//		registry.addResourceHandler(logicalPath)
//			.addResourceLocations("file:/" + absolutePath + "/");
//	}

//	@Override
//	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
//		resolvers.add(new PagingAndSortingArgumentResolver());
//	}

}
