import com.google.bitcoin.params.MainNetParams
import com.google.bitcoin.utils.BlockFileLoader
import scala.collection.convert.WrapAsScala._

trait BitcoinDRawBlockFile extends BlockSource {
	private val params = MainNetParams.get
	private val loader = new BlockFileLoader(params,BlockFileLoader.getReferenceClientBlockFileList)
	
	val stream = asScalaIterator(loader).toStream	
}