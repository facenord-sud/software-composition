import java.io.{InputStreamReader, BufferedReader, InputStream, DataOutputStream}
import java.net.{HttpURLConnection, URL}
import crawler.DSL.{get, host}

/**
 * Created by Numa de Montmollin on 17.10.14.
 */


object MasterGet{
  def main (args: Array[String]) {
    host("localhost")
    get("/")
    get("/users/sign_in")
    host params("key", "value") params("key2", "value2") get "/"
    get("users/sign_in")
    host.resetParams().params(Array(Map('key -> "test", 'value -> "value"), Map('key -> "qwe", 'value -> "vaqwelue"))).get("/")
  }
}