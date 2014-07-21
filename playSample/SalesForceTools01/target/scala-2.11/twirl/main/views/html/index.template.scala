
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._

/**/
object index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[String,List[Discussion],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message: String)(discussionList: List[Discussion]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.53*/("""

"""),_display_(/*3.2*/main("営業支援ツール")/*3.17*/ {_display_(Seq[Any](format.raw/*3.19*/("""

       """),format.raw/*5.8*/("""<input type ="text"><input type="button" name="createDescussion" value="話題作成">
       <div>
           <h2>最近の話題</h2>
           <ul>
				"""),_display_(/*9.6*/for(discussion <- discussionList) yield /*9.39*/ {_display_(Seq[Any](format.raw/*9.41*/("""
					"""),format.raw/*10.6*/("""<li><a href=""""),_display_(/*10.20*/discussion/*10.30*/.getUrl()),format.raw/*10.39*/("""">"""),_display_(/*10.42*/discussion/*10.52*/.getTitle()),format.raw/*10.63*/("""</a></li>
				""")))}),format.raw/*11.6*/("""
           """),format.raw/*12.12*/("""</ul>
       </div>
""")))}),format.raw/*14.2*/("""
"""))}
  }

  def render(message:String,discussionList:List[Discussion]): play.twirl.api.HtmlFormat.Appendable = apply(message)(discussionList)

  def f:((String) => (List[Discussion]) => play.twirl.api.HtmlFormat.Appendable) = (message) => (discussionList) => apply(message)(discussionList)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon Jul 21 15:25:27 JST 2014
                  SOURCE: /Users/yuna/dev/repo/playSample/SalesForceTools01/app/views/index.scala.html
                  HASH: 6d6f781730ac749391a25ff4e43eb3c772272f18
                  MATRIX: 740->1|879->52|907->55|930->70|969->72|1004->81|1168->220|1216->253|1255->255|1288->261|1329->275|1348->285|1378->294|1408->297|1427->307|1459->318|1504->333|1544->345|1595->366
                  LINES: 26->1|29->1|31->3|31->3|31->3|33->5|37->9|37->9|37->9|38->10|38->10|38->10|38->10|38->10|38->10|38->10|39->11|40->12|42->14
                  -- GENERATED --
              */
          