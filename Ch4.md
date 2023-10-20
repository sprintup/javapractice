## Tests
Now that we know what interactors are and how beneficial they are in working across a variety of gateways, we can see how they are also beneficial in working with tests as well. 

The base of the testing pyramid is made from unit tests, where the majority of your tests ought to be unit tests. Unit tests test small portions of your code to guard against regressions if the logic has to change. 

We will test a few of the methods that were extracted in the interactor during chapter 3 for demonstration purposes. 

Ultimately, it would be best to start development at this chapter by practicing test driven development (TDD). The process would be to write the test first using the Arrange, Act, Assert format and then getting the interactor to perform the work. This way the tests are written as you go and you simply have to make the controllers call the interactors instead of the tests. 

The name of the test should explain what unit of work, initial condition and expected result. This way you can exhaust all the edge cases and provide maximum test coverage. 

You can also test expected exceptions. 

### Notes
- [PR - Ch4: tests end ](https://github.com/sprintup/javapractice/pull/9/files)
