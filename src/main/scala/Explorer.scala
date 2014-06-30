import actions._

/**
 * Created with IntelliJ IDEA.
 * User: yzark
 * Date: 11/19/13
 * Time: 12:36 PM
 * To change this template use File | Settings | File Templates.
 */
object Explorer extends App{
  args.toList match{
    case "populate"::rest             => new BlocksReader(rest)
    case "closure"::rest              => new AddressesClosurer(rest)
    case "all"::rest                  =>
      val populater = new BlocksReader(if (rest.isEmpty) List("100000", "init") else rest)
      new AddressesClosurer(List(populater.start.toString, populater.end.toString))
      // new AddressesBalancer(rest) isn't really needed and just bloats database
    case _=> println
    ("""
      Available commands:
      populate [number of blocks] [init]
      closure
      all [number of blocks]
    """)
  }
}
