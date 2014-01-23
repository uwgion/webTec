
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
object meineAngebote extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[ArrayList[Route],ArrayList[Request],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(myRoutes:  ArrayList[Route])(myRequests: ArrayList[Request]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.63*/("""

"""),_display_(Seq[Any](/*3.2*/main("HöriMit")/*3.17*/ {_display_(Seq[Any](format.raw/*3.19*/("""

"""),_display_(Seq[Any](/*5.2*/if(session.get("driver") == "true")/*5.37*/{_display_(Seq[Any](format.raw/*5.38*/("""
	<fieldset>
	<legend>Angebotene Mitfahrgelegenheiten</legend>
	<div id="omm_thema-table" class="panel-group">
		
		"""),_display_(Seq[Any](/*10.4*/for((key) <- myRoutes) yield /*10.26*/{_display_(Seq[Any](format.raw/*10.27*/("""
			<div class="panel panel-default" id=""""),_display_(Seq[Any](/*11.42*/{key._id})),format.raw/*11.51*/("""">
				<div class="panel-heading">
				  <h4 class="panel-title">
				    <a data-toggle="collapse" data-parent="#omm_thema-table" href="#"""),_display_(Seq[Any](/*14.74*/{key._id})),format.raw/*14.83*/("""1">
				     <span class="omm_von">Von:</span> """),_display_(Seq[Any](/*15.45*/{key.startAdresse.fetch().name})),format.raw/*15.76*/(""" <span class="omm_nach">Nach:</span> """),_display_(Seq[Any](/*15.114*/{key.zielAdresse.fetch().name})),format.raw/*15.144*/("""
				    </a>
				  </h4>
				</div>
				<div class="panel-collapse collapse" id=""""),_display_(Seq[Any](/*19.47*/{key._id})),format.raw/*19.56*/("""1">
					<div class="panel-body">
							"""),_display_(Seq[Any](/*21.9*/_displayOffer(key)/*21.27*/("owner")/*21.36*/("6"))),format.raw/*21.41*/("""	
							</div>
			 		</div>
			 	</div>
		 	</div>
		""")))})),format.raw/*26.4*/("""
	</fieldset>

	<div class="row"></div>
""")))})),format.raw/*30.2*/("""
	<fieldset>
	<legend>Angefragte Mitfahrgelegenheiten</legend>
	<div id="omm_thema-table" class="panel-group">	
		"""),_display_(Seq[Any](/*34.4*/for((key) <- myRequests) yield /*34.28*/{_display_(Seq[Any](format.raw/*34.29*/("""
			<div class="panel panel-default" id=""""),_display_(Seq[Any](/*35.42*/{key.route.fetch()._id})),format.raw/*35.65*/("""">
				<div class="panel-heading">
				  <h4 class="panel-title">
				    <a data-toggle="collapse" data-parent="#omm_thema-table" href="#"""),_display_(Seq[Any](/*38.74*/{key._id})),format.raw/*38.83*/("""2">
				     <span class="omm_von">Von:</span> """),_display_(Seq[Any](/*39.45*/{key.route.fetch().startAdresse.fetch().name})),format.raw/*39.90*/(""" <span class="omm_nach">Nach:</span> """),_display_(Seq[Any](/*39.128*/{key.route.fetch().zielAdresse.fetch().name})),format.raw/*39.172*/("""
				    </a>
				  </h4>
				</div>
				<div class="panel-collapse collapse" id=""""),_display_(Seq[Any](/*43.47*/{key._id})),format.raw/*43.56*/("""2">
					<div class="panel-body">
							"""),_display_(Seq[Any](/*45.9*/_displayOffer(key.route.fetch())/*45.41*/("")/*45.45*/("6"))),format.raw/*45.50*/("""	
							</div>
			 		</div>
			 	</div>
		 	</div>
		""")))})),format.raw/*50.4*/("""
	</fieldset>
<script type="text/javascript"
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAjsbaoEWBxF2oxvLEenqLjERjfJICyyWg&sensor=true">
</script>
 	<script type="text/javascript" src="/assets/javascripts/omm_mapCanvases.js"></script>
 	<script type="text/javascript" src="/assets/javascripts/omm_offersPanel.js"></script>
""")))})))}
    }
    
    def render(myRoutes:ArrayList[Route],myRequests:ArrayList[Request]): play.api.templates.HtmlFormat.Appendable = apply(myRoutes)(myRequests)
    
    def f:((ArrayList[Route]) => (ArrayList[Request]) => play.api.templates.HtmlFormat.Appendable) = (myRoutes) => (myRequests) => apply(myRoutes)(myRequests)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Jan 23 16:30:07 CET 2014
                    SOURCE: C:/Users/uwe/git/webTec/webTec/app/views/meineAngebote.scala.html
                    HASH: 4dff01b49aa3e67e90ec99ecf3cc070ac933bfc0
                    MATRIX: 811->1|966->62|1005->67|1028->82|1067->84|1106->89|1149->124|1187->125|1344->247|1382->269|1421->270|1500->313|1531->322|1709->464|1740->473|1825->522|1878->553|1953->591|2006->621|2129->708|2160->717|2239->761|2266->779|2284->788|2311->793|2402->853|2478->898|2632->1017|2672->1041|2711->1042|2790->1085|2835->1108|3013->1250|3044->1259|3129->1308|3196->1353|3271->1391|3338->1435|3461->1522|3492->1531|3571->1575|3612->1607|3625->1611|3652->1616|3743->1676
                    LINES: 26->1|29->1|31->3|31->3|31->3|33->5|33->5|33->5|38->10|38->10|38->10|39->11|39->11|42->14|42->14|43->15|43->15|43->15|43->15|47->19|47->19|49->21|49->21|49->21|49->21|54->26|58->30|62->34|62->34|62->34|63->35|63->35|66->38|66->38|67->39|67->39|67->39|67->39|71->43|71->43|73->45|73->45|73->45|73->45|78->50
                    -- GENERATED --
                */
            