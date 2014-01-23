
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
object _errorSuccess extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](_display_(Seq[Any](/*2.2*/if(flash.get("success") != null)/*2.34*/ {_display_(Seq[Any](format.raw/*2.36*/("""
   <p class="alert alert-success">
       <i class="glyphicon glyphicon-ok"></i> &nbsp """),_display_(Seq[Any](/*4.54*/flash/*4.59*/.get("success"))),format.raw/*4.74*/("""
   </p>
""")))})),format.raw/*6.2*/("""
 """),_display_(Seq[Any](/*7.3*/if(flash.get("errors") != null)/*7.34*/ {_display_(Seq[Any](format.raw/*7.36*/("""
   <p class="alert alert-danger">
       <i class="glyphicon glyphicon-remove"></i> &nbsp """),_display_(Seq[Any](/*9.58*/flash/*9.63*/.get("errors"))),format.raw/*9.77*/("""
   </p>
""")))})))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Jan 16 21:29:59 CET 2014
                    SOURCE: C:/Users/uwe/git/webTec16/webTec/app/views/_errorSuccess.scala.html
                    HASH: f331ab77ed11714cf51c4d7f1fb3c08b1ea27463
                    MATRIX: 872->3|912->35|951->37|1077->128|1090->133|1126->148|1168->160|1206->164|1245->195|1284->197|1413->291|1426->296|1461->310
                    LINES: 29->2|29->2|29->2|31->4|31->4|31->4|33->6|34->7|34->7|34->7|36->9|36->9|36->9
                    -- GENERATED --
                */
            