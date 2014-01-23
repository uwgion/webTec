
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
object main extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,Html,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(title: String)(content: Html):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.32*/("""

<!DOCTYPE html>
<html lang="de">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

    <title>"""),_display_(Seq[Any](/*8.13*/title)),format.raw/*8.18*/("""</title>

    <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*10.50*/routes/*10.56*/.Assets.at("stylesheets/bootstrap.css"))),format.raw/*10.95*/("""">
    <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*11.50*/routes/*11.56*/.Assets.at("stylesheets/main.css"))),format.raw/*11.90*/("""">
    <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*12.55*/routes/*12.61*/.Assets.at("images/favicon.png"))),format.raw/*12.93*/("""">

    <script src=""""),_display_(Seq[Any](/*14.19*/routes/*14.25*/.Assets.at("javascripts/jquery-2.0.3.min.js"))),format.raw/*14.70*/("""" type="text/javascript"></script>
    <script src=""""),_display_(Seq[Any](/*15.19*/routes/*15.25*/.Assets.at("javascripts/bootstrap.js"))),format.raw/*15.63*/("""" type="text/javascript"></script>
	<script type="text/javascript" src=""""),_display_(Seq[Any](/*16.39*/routes/*16.45*/.Application.javascriptRoutes)),format.raw/*16.74*/(""""></script>
	<!-- <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script> -->

	
	
	
    <!-- Custom styles for this template -->


    <style type="text/css">
        body """),format.raw/*26.14*/("""{"""),format.raw/*26.15*/("""
        padding-top: 50px;
        """),format.raw/*28.9*/("""}"""),format.raw/*28.10*/("""


    </style>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src=""""),_display_(Seq[Any](/*35.19*/routes/*35.25*/.Assets.at("javascripts/html5shiv.js"))),format.raw/*35.63*/("""" type="text/javascript"></script>
    <script src=""""),_display_(Seq[Any](/*36.19*/routes/*36.25*/.Assets.at("javascripts/respond.min.js"))),format.raw/*36.65*/("""" type="text/javascript"></script>
    <![endif]-->
</head>
<body>

<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            """),_display_(Seq[Any](/*49.14*/if((request.cookies.get("sessionID") != null) || (session.get("sessionID") != null))/*49.98*/{_display_(Seq[Any](format.raw/*49.99*/("""
				<a class="navbar-brand" href=""""),_display_(Seq[Any](/*50.36*/routes/*50.42*/.Application.index())),format.raw/*50.62*/("""">Hallo """),_display_(Seq[Any](/*50.71*/session/*50.78*/.get("username"))),format.raw/*50.94*/("""</a>
            """)))}/*51.14*/else/*51.18*/{_display_(Seq[Any](format.raw/*51.19*/("""
				<a class="navbar-brand" href=""""),_display_(Seq[Any](/*52.36*/routes/*52.42*/.Application.index())),format.raw/*52.62*/("""">HöriMit</a>
            """)))})),format.raw/*53.14*/("""
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href=""""),_display_(Seq[Any](/*57.31*/routes/*57.37*/.Application.index())),format.raw/*57.57*/(""""><i class="glyphicon glyphicon-home"></i> Home</a></li>
                """),format.raw/*58.77*/("""
               """),format.raw/*59.59*/("""
            </ul>

            """),_display_(Seq[Any](/*62.14*/if((request.cookies.get("sessionID") != null) || (session.get("sessionID") != null))/*62.98*/{_display_(Seq[Any](format.raw/*62.99*/("""
            <ul class="nav navbar-nav navbar-right omm_navbar-buttons">
            	"""),_display_(Seq[Any](/*64.15*/if(session.get("driver") == "true")/*64.50*/{_display_(Seq[Any](format.raw/*64.51*/("""
					<li><a href=""""),_display_(Seq[Any](/*65.20*/routes/*65.26*/.Angebote.createOffer())),format.raw/*65.49*/("""">Angebot erstellen</a></li>
            	""")))})),format.raw/*66.15*/("""
				<li><a href=""""),_display_(Seq[Any](/*67.19*/routes/*67.25*/.Angebote.myOffers())),format.raw/*67.45*/("""">Meine Angebot</a></li>
				<li><a href=""""),_display_(Seq[Any](/*68.19*/routes/*68.25*/.Requests.displayRequests())),format.raw/*68.52*/("""">Meine Anfragen</a></li>
				<li class="dropdown">
		            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="glyphicon glyphicon-cog"></i></a>
		            <ul class="dropdown-menu">
		              <li class="dropdown-element"><a href="/logout">Logout</a></li>
	            	</ul>
          		</li>
		    </ul>   
		    """)))}/*76.8*/else/*76.12*/{_display_(Seq[Any](format.raw/*76.13*/("""
		    	<ul class="nav navbar-nav pull-right">
                	<li><a href=""""),_display_(Seq[Any](/*78.32*/routes/*78.38*/.Login.showLoginForm())),format.raw/*78.60*/("""">Login</a></li>
		    	</ul>
		    """)))})),format.raw/*80.8*/(""" 	
			</ul>
        </div><!--/.nav-collapse -->
        
    </div>
</div>

<div class="container omm_content">
	"""),_display_(Seq[Any](/*88.3*/_errorSuccess())),format.raw/*88.18*/("""
    """),_display_(Seq[Any](/*89.6*/content)),format.raw/*89.13*/("""
</div><!-- /.container -->

</body>
</html>
"""))}
    }
    
    def render(title:String,content:Html): play.api.templates.HtmlFormat.Appendable = apply(title)(content)
    
    def f:((String) => (Html) => play.api.templates.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Jan 19 08:23:19 CET 2014
                    SOURCE: C:/Users/uwe/git/webTec16/webTec/app/views/main.scala.html
                    HASH: be7dc98fac66825176215edc7432f1e996f18f54
                    MATRIX: 778->1|902->31|1061->155|1087->160|1182->219|1197->225|1258->264|1346->316|1361->322|1417->356|1510->413|1525->419|1579->451|1637->473|1652->479|1719->524|1808->577|1823->583|1883->621|1992->694|2007->700|2058->729|2288->931|2317->932|2380->968|2409->969|2589->1113|2604->1119|2664->1157|2753->1210|2768->1216|2830->1256|3338->1728|3431->1812|3470->1813|3542->1849|3557->1855|3599->1875|3644->1884|3660->1891|3698->1907|3735->1925|3748->1929|3787->1930|3859->1966|3874->1972|3916->1992|3975->2019|4144->2152|4159->2158|4201->2178|4302->2311|4346->2370|4415->2403|4508->2487|4547->2488|4670->2575|4714->2610|4753->2611|4809->2631|4824->2637|4869->2660|4944->2703|4999->2722|5014->2728|5056->2748|5135->2791|5150->2797|5199->2824|5566->3173|5579->3177|5618->3178|5732->3256|5747->3262|5791->3284|5859->3321|6009->3436|6046->3451|6087->3457|6116->3464
                    LINES: 26->1|29->1|36->8|36->8|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|42->14|42->14|42->14|43->15|43->15|43->15|44->16|44->16|44->16|54->26|54->26|56->28|56->28|63->35|63->35|63->35|64->36|64->36|64->36|77->49|77->49|77->49|78->50|78->50|78->50|78->50|78->50|78->50|79->51|79->51|79->51|80->52|80->52|80->52|81->53|85->57|85->57|85->57|86->58|87->59|90->62|90->62|90->62|92->64|92->64|92->64|93->65|93->65|93->65|94->66|95->67|95->67|95->67|96->68|96->68|96->68|104->76|104->76|104->76|106->78|106->78|106->78|108->80|116->88|116->88|117->89|117->89
                    -- GENERATED --
                */
            