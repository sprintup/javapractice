
## ch 2 clean code architecture
Clean code architecture was created by Robert Martin ("Uncle Bob") and has many different naming conventions. The clean-code architecture is language agnostic, but here we will look at a java example.

The benefits include:
- inversion of control of "Interactors" (Use cases) that act as main methods for interactions of the user. 
  - the interactors can be called by controllers or tests
- layers of abstraction called boundaries that separate application code from concrete implementation details, using interfaces.
  - this benefit allows for SOLID Principles to be practiced
- more maintainable, because gateways can be switch out easily, preventing vendor lock-in. 

### Boundaries
A boundary is simply an interface that is injected into a higher level component. For instance, gateways are injected into interactors, interactors are injected into controllers/jobs/tests, but interactors can also be injected into other interactors to reuse code. 
There are two boundary layers:
- between controllers and interactors 
- between interactors and gateways
  - this many-to-many relationship helps wrangle the many use cases 

### Directory Structure
The java\com\javapractice is the main directory for src files (a java language specific convention). All the following will assume this path is the 'root', even though it's not the project's root. I will exclude this path for brevity. 

```
- /app/controllers      // controllers are just api endpoints that recieve request objects and return response objects. (DTOs - data transfer objects). This is part of the first boundary.
- /app/domain       // contains the request and reponse objects. It exists at the root level of app directory so it can be accessed by all sides of the boundaries. It's just shapes (models), no execution logic. 
- /app/interactors      // use cases are separated by seeing them as 'interactions' by the user. See 'use cases' below. Requires @Service decorator to register it with IOC container to make it injectable. 
- /app/gateways     // gateways hold the interfaces that are used by the infrastructure injected into the interactors. This is the second boundary. It can be an API or a repository (@Repository makes it injectable)
- /infrastructure       // implements the details found in the gateways. This is the concrete implementation. 

```
### Use cases
Use cases can be broken down by 'As When Then' format. Or in other words 'As a <user, job, test, etc.>', 'When I <make a todo, press a button, etc.>', 'Then <something happens>'. 

## Notes
- Sometimes VScode trips, so you have to restart it.
![response route working](assets\response-working.png)