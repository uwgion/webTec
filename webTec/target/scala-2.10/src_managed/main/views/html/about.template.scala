
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
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
object about extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](_display_(Seq[Any](/*1.2*/main("H�riMit")/*1.17*/ {_display_(Seq[Any](format.raw/*1.19*/("""
    hurr durr2
""")))})),format.raw/*3.2*/("""
"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Jan 16 21:29:59 CET 2014
                    SOURCE: C:/Users/uwe/git/webTec16/webTec/app/views/about.scala.html
                    HASH: a248d58ee95da41c3efbc99821dfcaab2f8b4d27
                    MATRIX: 864->1|887->16|926->18|973->35
                    LINES: 29->1|29->1|29->1|31->3
                    -- GENERATED --
                */
            