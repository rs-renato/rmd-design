# rmd-design for unit testing

Rule-Messages-Domain Design. This simple project has laboratory proposal to shows one way to development 
 focused at unit test cases, based on rules, validation messages and domain model.
 
 - ```Rules```: are ```enums``` which implements a *rule contract* with an unique method *validate*.
 The rules encapsulate every business rules grouped by an specific business. For example, 
 in a ```UserRules```, is expected validations related to every ```User``` validation case:
 

```java
public enum UserRules implements Rules<User>{

	LOGIN{
		@Override
		public boolean validate(User user) throws ExceptionTypes {
			logger.info(".: Validation User login ...");
			return true;
		}
	},
	
	PASSWORD{
		@Override
		public boolean validate(User user) throws ExceptionTypes {
			logger.info(".: Validating User password ...");
			return true;
		}
	}
}
```
In this example, login and password were validated according with *user rules validations*

- ```Messages```: are ```enums``` which unique proposal: encapsulate messages to be thrown by *rules* in a negative validation. These validations
messages has a contract to ```ValidationMessages``` interface, which has an unique method ```getDescription```:

```java
public enum UserValidationMessages implements ValidationMessages{

	INVALID_LOGIN("The user login is invalid"),
	INVALID_PASSWORD("The password is invalid"),
	INVALID_BIRTHDATE("The birthdate is invalid");
	
	private String description;
	
	UserValidationMessages(String description) {
		this.description = description;
	}

	@Override
	public String getDescription() {
		return description;
	}
}
```
- ```Model```: are simple *java beans* models passed to *validations rules* execute their operations.

# Motivation
This design, try to demonstrate unit test validations through ```RulesInvoker```. The *rules invoker* is an abstract super class of every unit test, and provide only two methods: *validate* and *validateAndExpect*:

- ```validate```: this method is used to positive test cases. Doesn't expect to catch any validation message.
- ```validateAndExpect```: this method is used to negative test cases and expect to catch thwron validation messages.

While the first method checks possitive cases and has only two parameter (*rule and model*), the second, waits to be passed away three parameters (*rule, validation and model*).

The *RulesInvoker* should be parametrized by ```Rule, ValidationMessage and Model```:

```java
public abstract class RulesInvoker<R extends Rules<M>, V extends ValidationMessages, M>{...}
```

In sumary, the *invoker* calls in *rules* an specific rule validation (e.g. ```PASSWORD in UserRules```, which is executed, and validated by business rules; in a negative case, is thown a specific validation message for *invoker* wich knows how to manipulate (catch, compare and return to test) the answer.

An implementation of *UserRulesTest* is:

```java

public class UserRulesTest extends RulesInvoker<UserRules, UserValidationMessages, User> {

    @Test
    public void testUserValid(){

        User user = new User();
        user.setLogin("juvenal");
				//validates user login
        validate(UserRules.LOGIN, user);
    }

	@Test
	public void testInvalidUserLogin(){

		User user = new User();
		user.setLogin("ana");

    //Validates the rules for login and expects an 'invalid login message' from validator
		validateAndExpect(UserRules.LOGIN, UserValidationMessages.INVALID_LOGIN, user);
	}

}
```

This design has limitations (e.g dependency injection in rules) and is open to be improved and discussed.
