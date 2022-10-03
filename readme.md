## Springboot Validation
```
Spring Boot offers comprehensive support for Request validation using the Bean Validation 
specification. With Spring Boot, you can quickly add validation to your existing classes
with minimal effort. We’ll also take a look at how we can use validation groups 
to invoke different validations in different use cases.
```

This can be done by using the following annotation :


### @NotNull :
```
This annotation validates that the annotated property value is not null and 
Hibernate automatically adds the not null constraint to the column definition
same as @Column(nullable=false).

if, for any reason, we want to disable this Hibernate feature, 
all we need to do is to set:

spring.jpa.properties.hibernate.validator.apply_to_ddl=false
```
### @Length :
```
to say that a String field length must be between min and max.
```

### @Pattern :

```
to say that a string field is only valid when it matches a certain regular expression.
```
### @Min && @Max :

```
 to say that a numerical field is only valid when it’s value is above or below a certain value.```
```

### @Email :

```
 to say that a string field must be a valid email address.
```

### @NotEmpty :

```
to say that a list field must not empty.
```
### @NotBlank :

```
to say that a string field must not be the empty string (i.e. it must have at least one character). 
```

How to create custom validation annotation !!!

There are two main steps to create custom validation:

1- Create a new @interface to define our annotation:
```
@Documented
@Constraint(validatedBy = MaritalStatusValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface MaritalStatus {
    String message() default "Invalid marital status input";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

- @Documented: 
is a meta-annotation. You apply @Documented when defining an annotation, to ensure that classes using your annotation show this in their generated JavaDoc.

- @Constraint(validatedBy = MaritalStatusValidator.class)
determine the validator class implementation

-@Target( { ElementType.METHOD, ElementType.FIELD })
tag is used to specify at which type, the annotation is used, check ElementType enum.

-@Retention(RetentionPolicy.RUNTIME)
is used to specify to what level annotation will be available, check RetentionPolicy enum

```

2- Create validator class, this class should implement ConstraintValidator<MaritalStatusConstraint,String) and override isValid method :
```
public class MaritalStatusValidator implements 
  ConstraintValidator<MaritalStatus, String> {

    @Override
    public void initialize(MaritalStatusConstraint maritalStatus) {
    }

    @Override
    public boolean isValid(String contactField,
      ConstraintValidatorContext cxt) {
      //
       implementaion....
       //
    }

}
```