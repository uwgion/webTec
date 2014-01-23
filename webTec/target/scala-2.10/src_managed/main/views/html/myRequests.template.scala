
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
object myRequests extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[ArrayList[Request],ArrayList[Request],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(myNotApprovedRequests:  ArrayList[Request])(myCreatedRequests: ArrayList[Request]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.85*/("""

"""),_display_(Seq[Any](/*3.2*/main("HöriMit")/*3.17*/ {_display_(Seq[Any](format.raw/*3.19*/("""
<fieldset>
	<legend>Eigene Anfragen</legend>
	<div id="omm_thema-table" class="panel-group">
		
		"""),_display_(Seq[Any](/*8.4*/for((key) <- myCreatedRequests) yield /*8.35*/{_display_(Seq[Any](format.raw/*8.36*/("""
			<div class="panel panel-default" id=""""),_display_(Seq[Any](/*9.42*/{key._id})),format.raw/*9.51*/("""">
				<div class="panel-heading">
				  <h4 class="panel-title">
				    <a data-toggle="collapse" data-parent="#omm_thema-table" href="#"""),_display_(Seq[Any](/*12.74*/{key._id})),format.raw/*12.83*/("""1">
				     <span class="omm_von">Von:</span> """),_display_(Seq[Any](/*13.45*/{key.route.fetch().startAdresse.fetch().name})),format.raw/*13.90*/(""" <span class="omm_nach">Nach:</span> """),_display_(Seq[Any](/*13.128*/{key.route.fetch().zielAdresse.fetch().name})),format.raw/*13.172*/("""
				    </a>
				  </h4>
				</div>
				<div class="panel-collapse collapse" id=""""),_display_(Seq[Any](/*17.47*/{key._id})),format.raw/*17.56*/("""1">
					<div class="panel-body">
						"""),_display_(Seq[Any](/*19.8*/_displayRequest(key)/*19.28*/(""))),format.raw/*19.32*/("""
			 		</div>
			 	</div>
		 	</div>
		""")))})),format.raw/*23.4*/("""
		</div>
</fieldset>
<div class="row"></div>
"""),_display_(Seq[Any](/*27.2*/if(session.get("driver") == "true")/*27.37*/{_display_(Seq[Any](format.raw/*27.38*/("""
<fieldset>
	<legend>Eingegangene Anfragen</legend>
	<div id="omm_thema-table" class="panel-group">
		
		"""),_display_(Seq[Any](/*32.4*/for((key) <- myNotApprovedRequests) yield /*32.39*/{_display_(Seq[Any](format.raw/*32.40*/("""
			<div class="panel panel-default" id=""""),_display_(Seq[Any](/*33.42*/{key._id})),format.raw/*33.51*/("""1">
				<div class="panel-heading">
				  <h4 class="panel-title">
				    <a data-toggle="collapse" data-parent="#omm_thema-table" href="#"""),_display_(Seq[Any](/*36.74*/{key._id})),format.raw/*36.83*/("""2">
				     <span class="omm_von">Von:</span> """),_display_(Seq[Any](/*37.45*/{key.route.fetch().startAdresse.fetch().name})),format.raw/*37.90*/(""" <span class="omm_nach">Nach:</span> """),_display_(Seq[Any](/*37.128*/{key.route.fetch().zielAdresse.fetch().name})),format.raw/*37.172*/("""
				    </a>
				  </h4>
				</div>
				<div class="panel-collapse collapse" id=""""),_display_(Seq[Any](/*41.47*/{key._id})),format.raw/*41.56*/("""2">
					<div class="panel-body">
						"""),_display_(Seq[Any](/*43.8*/_displayRequest(key)/*43.28*/("owner"))),format.raw/*43.37*/("""
			 		</div>
			 	</div>
		 	</div>
		""")))})),format.raw/*47.4*/("""
	</div>
</fieldset>
""")))})),format.raw/*50.2*/("""
""")))})))}
    }
    
    def render(myNotApprovedRequests:ArrayList[Request],myCreatedRequests:ArrayList[Request]): play.api.templates.HtmlFormat.Appendable = apply(myNotApprovedRequests)(myCreatedRequests)
    
    def f:((ArrayList[Request]) => (ArrayList[Request]) => play.api.templates.HtmlFormat.Appendable) = (myNotApprovedRequests) => (myCreatedRequests) => apply(myNotApprovedRequests)(myCreatedRequests)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Jan 23 16:30:07 CET 2014
                    SOURCE: C:/Users/uwe/git/webTec/webTec/app/views/myRequests.scala.html
                    HASH: 463ee95e41ca311d0a24e668a28b8d760c7c4366
                    MATRIX: 810->1|987->84|1026->89|1049->104|1088->106|1227->211|1273->242|1311->243|1389->286|1419->295|1597->437|1628->446|1713->495|1780->540|1855->578|1922->622|2045->709|2076->718|2154->761|2183->781|2209->785|2284->829|2370->880|2414->915|2453->916|2599->1027|2650->1062|2689->1063|2768->1106|2799->1115|2978->1258|3009->1267|3094->1316|3161->1361|3236->1399|3303->1443|3426->1530|3457->1539|3535->1582|3564->1602|3595->1611|3670->1655|3726->1680
                    LINES: 26->1|29->1|31->3|31->3|31->3|36->8|36->8|36->8|37->9|37->9|40->12|40->12|41->13|41->13|41->13|41->13|45->17|45->17|47->19|47->19|47->19|51->23|55->27|55->27|55->27|60->32|60->32|60->32|61->33|61->33|64->36|64->36|65->37|65->37|65->37|65->37|69->41|69->41|71->43|71->43|71->43|75->47|78->50
                    -- GENERATED --
                */
            