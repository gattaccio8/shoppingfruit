# shoppingfruit

#From github https://github.com/gattaccio8/shoppingfruit.git

step 1
git clone https://github.com/gattaccio8/shoppingfruit.git

Step 2
If you run the project from an IDE the main class will be Checkout.scala
or you can run it from terminal as the project contains an sbt jar + an sbt.sh script so you can type "./sbt.sh run"
you will then be prompt to enter the order list in the format "Apple, Apple, Orange, Apple"
Discount are applied as for the latest requirements in step 2.

From the project directory:

$ ./sbt.sh run
Picked up JAVA_TOOL_OPTIONS: -Dfile.encoding=UTF-8
Java HotSpot(TM) 64-Bit Server VM warning: ignoring option MaxPermSize=256m; support was removed in 8.0
[info] Loading project definition from /Users/gattopas/dev/projects/shoppingfruit/project
[info] Set current project to shoppingfruit (in build file:/Users/gattopas/dev/projects/shoppingfruit/)
[info] Compiling 1 Scala source to /Users/gattopas/dev/projects/shoppingfruit/target/scala-2.11/classes...
[info] Running Checkout
In this shop we only sell apples and oranges

Enter your fruit order in a format like: Apple, Apple, Orange, Apple

Apple, Apple, Orange, Apple
You ordered [ Apple(Apple,0.6), Apple(Apple,0.6), Orange(Orange,0.25), Apple(Apple,0.6) ] and the total cost => 1.45



########################################## git tags ##############################################

Each requirement has a git tag as requested and are listed below.

Step 1: Shopping cart
    ● You are building a checkout system for a shop which only sells apples and oranges. (git show v1.0)
    ● Apples cost 60p and oranges cost 25p. (git show v1.1)
    ● Build a checkout system which takes a list of items scanned at the till and outputs the total cost (git show v1.2)
    ● For example: [ Apple, Apple, Orange, Apple ] => £2.05 (git show v1.3)
    ● Make reasonable assumptions about the inputs to your solution; for example, many candidates take a list of strings as input (git show v1.4)

Step 2: Simple offers
    ● The shop decides to introduce two new offers
        ○ buy one, get one free on Apples (git show v2.0)
        ○ 3 for the price of 2 on Oranges (git show v2.1)
    ● Update your checkout functions accordingly

