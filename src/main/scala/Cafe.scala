import	scala.util.Try
import	scala.concurrent.future
import	scala.concurrent.Future
import	scala.concurrent.ExecutionContext.Implicits.global
import	scala.concurrent.duration._
import	scala.util.Random

type	CoffeeBeans	=	String
type	GroundCoffee	=	String
type	Milk	=	String
type	FrothedMilk	=	String
type	Espresso	=	String
type	Cappuccino	=	String


case	class	Water(temperature:	Int)
case	class	GrindingException(msg:	String)	extends	Exception(msg)
case	class	FrothingException(msg:	String)	extends	Exception(msg)
case	class	WaterBoilingException(msg:	String)	extends	Exception(msg)
case	class	BrewingException(msg:	String)	extends	Exception(msg)



object Cafe {

  def grind(beans: CoffeeBeans): Future[GroundCoffee] = Future {
    println("start	grinding...")
    Thread.sleep(Random.nextInt(2000))
    if (beans == "baked	beans") throw GrindingException("are	you	joking?")
    println("finished	grinding...")
    s"ground	coffee	of	$beans"
  }

  def heatWater(water: Water): Future[Water] = Future {
    println("heating	the	water	now")
    Thread.sleep(Random.nextInt(2000))
    println("hot,	it's	hot!")
    water.copy(temperature = 85)
  }

  def frothMilk(milk: Milk): Future[FrothedMilk] = Future {
    println("milk	frothing	system	engaged!")
    Thread.sleep(Random.nextInt(2000))
    println("shutting	down	milk	frothing	system")
    s"frothed	$milk"
  }

  def brew(coffee: GroundCoffee, heatedWater: Water): Future[Espresso] = Future {
    println("happy	brewing	:)")
    Thread.sleep(Random.nextInt(2000))
    println("it's	brewed!")
    "espresso"

  }
}
