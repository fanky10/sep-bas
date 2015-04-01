<%@ include file="/WEB-INF/pages/web/common/taglibs.jsp"%>
<content tag="styles"> <%-- some link rel to this page in specific --%>

</content>
<content tag="jscriptlibs">
<script type="text/javascript" src="<c:url value="/js/vendor/modernizr.js"/>"></script>
</content>
<content tag="jscript">
    <script>
        $(document).foundation();
    </script>
</content>
<content tag="bodyContent">
   <div class="row">
            <div class="large-3 columns" style="text-align:center;">
                <h1 class="txtLocal">LOCAL<br>84</h1>
            </div>
            <div class="large-1 columns">
                <h1><br>-</h1>
            </div>
            <div class="large-3 columns" style="text-align:center;">
                <h1 class="txtVisita">VISITANTE<br>103</h1>
            </div>
            <div class="large-4 columns">
                <div class="panel callout radius">
                    <h5 style="text-align:center;"><strong>03/10/2014</strong></h5>
                    <h6>Estadio de Central</h6>
                    <h6>Arbitro: Nestor Pitana</h6>
                </div>
            </div>
        </div>
       
        <div class="row">
            <ul class="tabs" data-tab>
                <li class="tab-title active" style="width: 20%;"><a href="#panel1"><br><strong>General</strong><br><br></a></li>
                <li class="tab-title" style="width: 20%;"><a href="#panel2"><strong>1&#186; Cuarto</strong><br>Local: 12<br>Visita: 17</a></li>
                <li class="tab-title" style="width: 20%;"><a href="#panel3" ><strong>2&#186; Cuarto</strong><br>Local: 33<br>Visita: 34</a></li>
                <li class="tab-title" style="width: 20%;"><a href="#panel4" ><strong>3&#186; Cuarto</strong><br>Local: 17<br>Visita: 24</a></li>
                <li class="tab-title" style="width: 20%;"><a href="#panel5" ><strong>4&#186; Cuarto</strong><br>Local: 24<br>Visita: 43</a></li>
            </ul>
            <div class="tabs-content">
                <div class="content active" id="panel1">
                    <ul class="tabs" data-tab>
                        <li class="tab-title active"><a href="#panel11"><div class="txtLocal">Local</div></a></li>
                        <li class="tab-title"><a href="#panel12"><div class="txtVisita">Visita</div></a></li>
                    </ul>
                    <div class="tabs-content">
                        <div class="content active" id="panel11">
                            <table width="100%" border="0">
                                <tr>
                                    <th scope="col">Numero</th>
                                    <th scope="col">Nombre</th>
                                    <th scope="col">Simples</th>
                                    <th scope="col">Dobles</th>
                                    <th scope="col">Triples</th>
                                    <th scope="col">Asistencias</th>
                                    <th scope="col">Faltas</th>
                                </tr>
                                <tr>
                                    <td align="center">32</td>
                                    <td>Jugador Local</td>
                                    <td align="center">2</td>
                                    <td align="center">3</td>
                                    <td align="center">4</td>
                                    <td align="center">5</td>
                                    <td align="center">3</td>
                                </tr>
                            </table>
                        </div>
                        <div class="content" id="panel12">
                            <table width="100%" border="0">
                                <tr>
                                    <th scope="col">Numero</th>
                                    <th scope="col">Nombre</th>
                                    <th scope="col">Simples</th>
                                    <th scope="col">Dobles</th>
                                    <th scope="col">Triples</th>
                                    <th scope="col">Asistencias</th>
                                    <th scope="col">Faltas</th>
                                </tr>
                                <tr>
                                    <td align="center">99</td>
                                    <td>Jugador Visitante</td>
                                    <td align="center">2</td>
                                    <td align="center">3</td>
                                    <td align="center">4</td>
                                    <td align="center">5</td>
                                    <td align="center">3</td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="content" id="panel2">
                    <ul class="tabs" data-tab>
                        <li class="tab-title active"><a href="#panel21"><div class="txtLocal">Local</div></a></li>
                        <li class="tab-title"><a href="#panel22" ><div class="txtVisita">Visita</div></a></li>
                    </ul>
                    <div class="tabs-content">
                        <div class="content active" id="panel21">
                            <table width="100%" border="0">
                                <tr>
                                    <th scope="col">Numero</th>
                                    <th scope="col">Nombre</th>
                                    <th scope="col">Simples</th>
                                    <th scope="col">Dobles</th>
                                    <th scope="col">Triples</th>
                                    <th scope="col">Asistencias</th>
                                    <th scope="col">Faltas</th>
                                </tr>
                                <tr>
                                    <td align="center">32</td>
                                    <td>Jugador Local</td>
                                    <td align="center">2</td>
                                    <td align="center">3</td>
                                    <td align="center">4</td>
                                    <td align="center">5</td>
                                    <td align="center">3</td>
                                </tr>
                            </table>
                        </div>
                        <div class="content" id="panel22">
                            <table width="100%" border="0">
                                <tr>
                                    <th scope="col">Numero</th>
                                    <th scope="col">Nombre</th>
                                    <th scope="col">Simples</th>
                                    <th scope="col">Dobles</th>
                                    <th scope="col">Triples</th>
                                    <th scope="col">Asistencias</th>
                                    <th scope="col">Faltas</th>
                                </tr>
                                <tr>
                                    <td align="center">99</td>
                                    <td>Jugador Visitante</td>
                                    <td align="center">2</td>
                                    <td align="center">3</td>
                                    <td align="center">4</td>
                                    <td align="center">5</td>
                                    <td align="center">3</td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="content" id="panel3">
                    <ul class="tabs" data-tab>
                        <li class="tab-title active"><a href="#panel31"><div class="txtLocal">Local</div></a></li>
                        <li class="tab-title"><a href="#panel32" ><div class="txtVisita">Visita</div></a></li>
                    </ul>
                    <div class="tabs-content">
                        <div class="content active" id="panel31">
                            <table width="100%" border="0">
                                <tr>
                                    <th scope="col">Numero</th>
                                    <th scope="col">Nombre</th>
                                    <th scope="col">Simples</th>
                                    <th scope="col">Dobles</th>
                                    <th scope="col">Triples</th>
                                    <th scope="col">Asistencias</th>
                                    <th scope="col">Faltas</th>
                                </tr>
                                <tr>
                                    <td align="center">32</td>
                                    <td>Jugador Local</td>
                                    <td align="center">2</td>
                                    <td align="center">3</td>
                                    <td align="center">4</td>
                                    <td align="center">5</td>
                                    <td align="center">3</td>
                                </tr>
                            </table>
                        </div>
                        <div class="content" id="panel32">
                            <table width="100%" border="0">
                                <tr>
                                    <th scope="col">Numero</th>
                                    <th scope="col">Nombre</th>
                                    <th scope="col">Simples</th>
                                    <th scope="col">Dobles</th>
                                    <th scope="col">Triples</th>
                                    <th scope="col">Asistencias</th>
                                    <th scope="col">Faltas</th>
                                </tr>
                                <tr>
                                    <td align="center">99</td>
                                    <td>Jugador Visitante</td>
                                    <td align="center">2</td>
                                    <td align="center">3</td>
                                    <td align="center">4</td>
                                    <td align="center">5</td>
                                    <td align="center">3</td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="content" id="panel4">
                    <ul class="tabs" data-tab>
                        <li class="tab-title active"><a href="#panel41"><div class="txtLocal">Local</div></a></li>
                        <li class="tab-title"><a href="#panel42" ><div class="txtVisita">Visita</div></a></li>
                    </ul>
                    <div class="tabs-content">
                        <div class="content active" id="panel41">
                            <table width="100%" border="0">
                                <tr>
                                    <th scope="col">Numero</th>
                                    <th scope="col">Nombre</th>
                                    <th scope="col">Simples</th>
                                    <th scope="col">Dobles</th>
                                    <th scope="col">Triples</th>
                                    <th scope="col">Asistencias</th>
                                    <th scope="col">Faltas</th>
                                </tr>
                                <tr>
                                    <td align="center">32</td>
                                    <td>Jugador Local</td>
                                    <td align="center">2</td>
                                    <td align="center">3</td>
                                    <td align="center">4</td>
                                    <td align="center">5</td>
                                    <td align="center">3</td>
                                </tr>
                            </table>
                        </div>
                        <div class="content" id="panel42">
                            <table width="100%" border="0">
                                <tr>
                                    <th scope="col">Numero</th>
                                    <th scope="col">Nombre</th>
                                    <th scope="col">Simples</th>
                                    <th scope="col">Dobles</th>
                                    <th scope="col">Triples</th>
                                    <th scope="col">Asistencias</th>
                                    <th scope="col">Faltas</th>
                                </tr>
                                <tr>
                                    <td align="center">99</td>
                                    <td>Jugador Visitante</td>
                                    <td align="center">2</td>
                                    <td align="center">3</td>
                                    <td align="center">4</td>
                                    <td align="center">5</td>
                                    <td align="center">3</td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="content" id="panel5">
                    <ul class="tabs" data-tab>
                        <li class="tab-title active"><a href="#panel51"><div class="txtLocal">Local</div></a></li>
                        <li class="tab-title"><a href="#panel52" ><div class="txtVisita">Visitante</div></a></li>
                    </ul>
                    <div class="tabs-content">
                        <div class="content active" id="panel51">
                            <table width="100%" border="0">
                                <tr>
                                    <th scope="col">Numero</th>
                                    <th scope="col">Nombre</th>
                                    <th scope="col">Simples</th>
                                    <th scope="col">Dobles</th>
                                    <th scope="col">Triples</th>
                                    <th scope="col">Asistencias</th>
                                    <th scope="col">Faltas</th>
                                </tr>
                                <tr>
                                    <td align="center">32</td>
                                    <td>Jugador Local</td>
                                    <td align="center">2</td>
                                    <td align="center">3</td>
                                    <td align="center">4</td>
                                    <td align="center">5</td>
                                    <td align="center">3</td>
                                </tr>
                            </table>
                        </div>
                        <div class="content" id="panel52">
                            <table width="100%" border="0">
                                <tr>
                                    <th scope="col">Numero</th>
                                    <th scope="col">Nombre</th>
                                    <th scope="col">Simples</th>
                                    <th scope="col">Dobles</th>
                                    <th scope="col">Triples</th>
                                    <th scope="col">Asistencias</th>
                                    <th scope="col">Faltas</th>
                                </tr>
                                <tr>
                                    <td align="center">99</td>
                                    <td>Jugador Visitante</td>
                                    <td align="center">2</td>
                                    <td align="center">3</td>
                                    <td align="center">4</td>
                                    <td align="center">5</td>
                                    <td align="center">3</td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
</content>