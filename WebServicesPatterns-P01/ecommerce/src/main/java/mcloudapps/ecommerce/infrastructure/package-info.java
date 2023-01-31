@org.springframework.modulith.ApplicationModule(
    allowedDependencies = {"infrastructure::repositories", "infrastructure::models",  "infrastructure::mappers", 
    "domain::port", "dtos::requests", "dtos::responses"}
    )
package mcloudapps.ecommerce.infrastructure;
