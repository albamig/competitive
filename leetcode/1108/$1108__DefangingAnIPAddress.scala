object $1108__DefangingAnIPAddress extends App {
  def defangIPaddr(address: String): String = {
    address.replace(".", "[.]")
  }

  println(defangIPaddr("1.1.1.1"))
}
