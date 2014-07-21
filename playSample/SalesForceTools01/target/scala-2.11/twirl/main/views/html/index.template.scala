
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

       """),format.raw/*5.8*/("""<input type ="text" name="discussionText">
       <input type="button" name="createDiscussion" value="話題作成">

       <div>
           <h2>"""),_display_(/*9.17*/message),format.raw/*9.24*/("""</h2>
           <ul>
				"""),_display_(/*11.6*/for(discussion <- discussionList) yield /*11.39*/ {_display_(Seq[Any](format.raw/*11.41*/("""
					"""),format.raw/*12.6*/("""<li><a href=""""),_display_(/*12.20*/discussion/*12.30*/.getUrl()),format.raw/*12.39*/("""">"""),_display_(/*12.42*/discussion/*12.52*/.getTitle()),format.raw/*12.63*/("""</a></li>
				""")))}),format.raw/*13.6*/("""
           """),format.raw/*14.12*/("""</ul>
       </div>
""")))}),format.raw/*16.2*/("""
"""))}
  }

  def render(message:String,discussionList:List[Discussion]): play.twirl.api.HtmlFormat.Appendable = apply(message)(discussionList)

  def f:((String) => (List[Discussion]) => play.twirl.api.HtmlFormat.Appendable) = (message) => (discussionList) => apply(message)(discussionList)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon Jul 21 20:51:21 JST 2014
                  SOURCE: /Users/yuna/dev/repo/repo/playSample/SalesForceTools01/app/views/index.scala.html
                  HASH: 60d7fc38e531d14d39f3b0bfbde31a45956d2e84
                  MATRIX: 740->1|879->52|907->55|930->70|969->72|1004->81|1169->220|1196->227|1249->254|1298->287|1338->289|1371->295|1412->309|1431->319|1461->328|1491->331|1510->341|1542->352|1587->367|1627->379|1678->400
                  LINES: 26->1|29->1|31->3|31->3|31->3|33->5|37->9|37->9|39->11|39->11|39->11|40->12|40->12|40->12|40->12|40->12|40->12|40->12|41->13|42->14|44->16
                  -- GENERATED --
              */
          