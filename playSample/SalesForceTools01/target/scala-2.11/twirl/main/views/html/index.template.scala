
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

"""),_display_(/*3.2*/main("@message")/*3.18*/ {_display_(Seq[Any](format.raw/*3.20*/("""
"""),format.raw/*4.1*/("""<form action="" method="GET">
       <input type ="text" name="discussionText">
       <input type="button" name="createDiscussion" value="Discussion">
</form>
<form action="discussion" method="GET">
       <div>
           <h2>"""),_display_(/*10.17*/message),format.raw/*10.24*/("""</h2>
           <ul>
				"""),_display_(/*12.6*/for(discussion <- discussionList) yield /*12.39*/ {_display_(Seq[Any](format.raw/*12.41*/("""
					"""),format.raw/*13.6*/("""<li><a href="/discussion/"""),_display_(/*13.32*/discussion/*13.42*/.getUrl()),format.raw/*13.51*/("""">"""),_display_(/*13.54*/discussion/*13.64*/.getTitle()),format.raw/*13.75*/("""</a></li>
				""")))}),format.raw/*14.6*/("""
           """),format.raw/*15.12*/("""</ul>
       </div>
</form>
""")))}),format.raw/*18.2*/("""
"""))}
  }

  def render(message:String,discussionList:List[Discussion]): play.twirl.api.HtmlFormat.Appendable = apply(message)(discussionList)

  def f:((String) => (List[Discussion]) => play.twirl.api.HtmlFormat.Appendable) = (message) => (discussionList) => apply(message)(discussionList)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon Jul 21 23:30:43 JST 2014
                  SOURCE: /Users/yuna/dev/repo/repo/playSample/SalesForceTools01/app/views/index.scala.html
                  HASH: d782c57a99d23371c576b7a05efd6b2b6fd5e571
                  MATRIX: 740->1|879->52|907->55|931->71|970->73|997->74|1253->303|1281->310|1334->337|1383->370|1423->372|1456->378|1509->404|1528->414|1558->423|1588->426|1607->436|1639->447|1684->462|1724->474|1783->503
                  LINES: 26->1|29->1|31->3|31->3|31->3|32->4|38->10|38->10|40->12|40->12|40->12|41->13|41->13|41->13|41->13|41->13|41->13|41->13|42->14|43->15|46->18
                  -- GENERATED --
              */
          