(function(e){function t(t){for(var n,o,s=t[0],c=t[1],d=t[2],f=0,u=[];f<s.length;f++)o=s[f],Object.prototype.hasOwnProperty.call(r,o)&&r[o]&&u.push(r[o][0]),r[o]=0;for(n in c)Object.prototype.hasOwnProperty.call(c,n)&&(e[n]=c[n]);l&&l(t);while(u.length)u.shift()();return i.push.apply(i,d||[]),a()}function a(){for(var e,t=0;t<i.length;t++){for(var a=i[t],n=!0,s=1;s<a.length;s++){var c=a[s];0!==r[c]&&(n=!1)}n&&(i.splice(t--,1),e=o(o.s=a[0]))}return e}var n={},r={app:0},i=[];function o(t){if(n[t])return n[t].exports;var a=n[t]={i:t,l:!1,exports:{}};return e[t].call(a.exports,a,a.exports,o),a.l=!0,a.exports}o.m=e,o.c=n,o.d=function(e,t,a){o.o(e,t)||Object.defineProperty(e,t,{enumerable:!0,get:a})},o.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},o.t=function(e,t){if(1&t&&(e=o(e)),8&t)return e;if(4&t&&"object"===typeof e&&e&&e.__esModule)return e;var a=Object.create(null);if(o.r(a),Object.defineProperty(a,"default",{enumerable:!0,value:e}),2&t&&"string"!=typeof e)for(var n in e)o.d(a,n,function(t){return e[t]}.bind(null,n));return a},o.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return o.d(t,"a",t),t},o.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},o.p="/";var s=window["webpackJsonp"]=window["webpackJsonp"]||[],c=s.push.bind(s);s.push=t,s=s.slice();for(var d=0;d<s.length;d++)t(s[d]);var l=c;i.push([0,"chunk-vendors"]),a()})({0:function(e,t,a){e.exports=a("56d7")},"034f":function(e,t,a){"use strict";var n=a("85ec"),r=a.n(n);r.a},4678:function(e,t,a){var n={"./af":"2bfb","./af.js":"2bfb","./ar":"8e73","./ar-dz":"a356","./ar-dz.js":"a356","./ar-kw":"423e","./ar-kw.js":"423e","./ar-ly":"1cfd","./ar-ly.js":"1cfd","./ar-ma":"0a84","./ar-ma.js":"0a84","./ar-sa":"8230","./ar-sa.js":"8230","./ar-tn":"6d83","./ar-tn.js":"6d83","./ar.js":"8e73","./az":"485c","./az.js":"485c","./be":"1fc1","./be.js":"1fc1","./bg":"84aa","./bg.js":"84aa","./bm":"a7fa","./bm.js":"a7fa","./bn":"9043","./bn.js":"9043","./bo":"d26a","./bo.js":"d26a","./br":"6887","./br.js":"6887","./bs":"2554","./bs.js":"2554","./ca":"d716","./ca.js":"d716","./cs":"3c0d","./cs.js":"3c0d","./cv":"03ec","./cv.js":"03ec","./cy":"9797","./cy.js":"9797","./da":"0f14","./da.js":"0f14","./de":"b469","./de-at":"b3eb","./de-at.js":"b3eb","./de-ch":"bb71","./de-ch.js":"bb71","./de.js":"b469","./dv":"598a","./dv.js":"598a","./el":"8d47","./el.js":"8d47","./en-au":"0e6b","./en-au.js":"0e6b","./en-ca":"3886","./en-ca.js":"3886","./en-gb":"39a6","./en-gb.js":"39a6","./en-ie":"e1d3","./en-ie.js":"e1d3","./en-il":"7333","./en-il.js":"7333","./en-in":"ec2e","./en-in.js":"ec2e","./en-nz":"6f50","./en-nz.js":"6f50","./en-sg":"b7e9","./en-sg.js":"b7e9","./eo":"65db","./eo.js":"65db","./es":"898b","./es-do":"0a3c","./es-do.js":"0a3c","./es-us":"55c9","./es-us.js":"55c9","./es.js":"898b","./et":"ec18","./et.js":"ec18","./eu":"0ff2","./eu.js":"0ff2","./fa":"8df4","./fa.js":"8df4","./fi":"81e9","./fi.js":"81e9","./fil":"d69a","./fil.js":"d69a","./fo":"0721","./fo.js":"0721","./fr":"9f26","./fr-ca":"d9f8","./fr-ca.js":"d9f8","./fr-ch":"0e49","./fr-ch.js":"0e49","./fr.js":"9f26","./fy":"7118","./fy.js":"7118","./ga":"5120","./ga.js":"5120","./gd":"f6b4","./gd.js":"f6b4","./gl":"8840","./gl.js":"8840","./gom-deva":"aaf2","./gom-deva.js":"aaf2","./gom-latn":"0caa","./gom-latn.js":"0caa","./gu":"e0c5","./gu.js":"e0c5","./he":"c7aa","./he.js":"c7aa","./hi":"dc4d","./hi.js":"dc4d","./hr":"4ba9","./hr.js":"4ba9","./hu":"5b14","./hu.js":"5b14","./hy-am":"d6b6","./hy-am.js":"d6b6","./id":"5038","./id.js":"5038","./is":"0558","./is.js":"0558","./it":"6e98","./it-ch":"6f12","./it-ch.js":"6f12","./it.js":"6e98","./ja":"079e","./ja.js":"079e","./jv":"b540","./jv.js":"b540","./ka":"201b","./ka.js":"201b","./kk":"6d79","./kk.js":"6d79","./km":"e81d","./km.js":"e81d","./kn":"3e92","./kn.js":"3e92","./ko":"22f8","./ko.js":"22f8","./ku":"2421","./ku.js":"2421","./ky":"9609","./ky.js":"9609","./lb":"440c","./lb.js":"440c","./lo":"b29d","./lo.js":"b29d","./lt":"26f9","./lt.js":"26f9","./lv":"b97c","./lv.js":"b97c","./me":"293c","./me.js":"293c","./mi":"688b","./mi.js":"688b","./mk":"6909","./mk.js":"6909","./ml":"02fb","./ml.js":"02fb","./mn":"958b","./mn.js":"958b","./mr":"39bd","./mr.js":"39bd","./ms":"ebe4","./ms-my":"6403","./ms-my.js":"6403","./ms.js":"ebe4","./mt":"1b45","./mt.js":"1b45","./my":"8689","./my.js":"8689","./nb":"6ce3","./nb.js":"6ce3","./ne":"3a39","./ne.js":"3a39","./nl":"facd","./nl-be":"db29","./nl-be.js":"db29","./nl.js":"facd","./nn":"b84c","./nn.js":"b84c","./oc-lnc":"167b","./oc-lnc.js":"167b","./pa-in":"f3ff","./pa-in.js":"f3ff","./pl":"8d57","./pl.js":"8d57","./pt":"f260","./pt-br":"d2d4","./pt-br.js":"d2d4","./pt.js":"f260","./ro":"972c","./ro.js":"972c","./ru":"957c","./ru.js":"957c","./sd":"6784","./sd.js":"6784","./se":"ffff","./se.js":"ffff","./si":"eda5","./si.js":"eda5","./sk":"7be6","./sk.js":"7be6","./sl":"8155","./sl.js":"8155","./sq":"c8f3","./sq.js":"c8f3","./sr":"cf1e","./sr-cyrl":"13e9","./sr-cyrl.js":"13e9","./sr.js":"cf1e","./ss":"52bd","./ss.js":"52bd","./sv":"5fbd","./sv.js":"5fbd","./sw":"74dc","./sw.js":"74dc","./ta":"3de5","./ta.js":"3de5","./te":"5cbb","./te.js":"5cbb","./tet":"576c","./tet.js":"576c","./tg":"3b1b","./tg.js":"3b1b","./th":"10e8","./th.js":"10e8","./tl-ph":"0f38","./tl-ph.js":"0f38","./tlh":"cf75","./tlh.js":"cf75","./tr":"0e81","./tr.js":"0e81","./tzl":"cf51","./tzl.js":"cf51","./tzm":"c109","./tzm-latn":"b53d","./tzm-latn.js":"b53d","./tzm.js":"c109","./ug-cn":"6117","./ug-cn.js":"6117","./uk":"ada2","./uk.js":"ada2","./ur":"5294","./ur.js":"5294","./uz":"2e8c","./uz-latn":"010e","./uz-latn.js":"010e","./uz.js":"2e8c","./vi":"2921","./vi.js":"2921","./x-pseudo":"fd7e","./x-pseudo.js":"fd7e","./yo":"7f33","./yo.js":"7f33","./zh-cn":"5c3a","./zh-cn.js":"5c3a","./zh-hk":"49ab","./zh-hk.js":"49ab","./zh-mo":"3a6c","./zh-mo.js":"3a6c","./zh-tw":"90ea","./zh-tw.js":"90ea"};function r(e){var t=i(e);return a(t)}function i(e){if(!a.o(n,e)){var t=new Error("Cannot find module '"+e+"'");throw t.code="MODULE_NOT_FOUND",t}return n[e]}r.keys=function(){return Object.keys(n)},r.resolve=i,e.exports=r,r.id="4678"},"504f":function(e,t,a){"use strict";var n=a("5fb6"),r=a.n(n);r.a},"56d7":function(e,t,a){"use strict";a.r(t);a("e260"),a("e6cf"),a("cca6"),a("a79d");var n=a("2b0e"),r=a("5f5b"),i=a("b1e0"),o=a("c1df"),s=a.n(o),c=a("87f4"),d=a.n(c),l=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{attrs:{id:"app"}},[a("div",[a("Topbar")],1),a("div",[a("div",[a("router-view",{attrs:{podnice:e.podnice}})],1)])])},f=[],u=(a("d3b7"),function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("b-navbar",{attrs:{toggleable:"lg",type:"dark",variant:"info",fixed:"top"}},[a("b-navbar-toggle",{attrs:{target:"nav-collapse"}}),a("b-collapse",{attrs:{id:"nav-collapse","is-nav":""}},[a("b-navbar-nav",{directives:[{name:"show",rawName:"v-show",value:e.routes.length,expression:"routes.length"}]},e._l(e.routes,(function(t,n){return a("b-nav-item",{key:n},[a("router-link",{staticClass:"router-link",attrs:{to:t.path}},[e._v(" "+e._s(t.name)+" ")])],1)})),1)],1)],1)],1)}),b=[],m=(a("4160"),a("b0c0"),a("159b"),{data:function(){return{routes:[]}},created:function(){var e=this;this.$router.options.routes.forEach((function(t){e.routes.push({name:t.name,path:t.path})}))}}),p=m,v=(a("72bf"),a("2877")),h=Object(v["a"])(p,u,b,!1,null,"13ba71f9",null),j=h.exports,k={restIp:"83.212.82.142:8081/v1"},g={components:{Topbar:j},data:function(){return{podnice:[]}},created:function(){var e=this;fetch(k.restIp+"/podnice",{method:"get"}).then((function(e){return e.json()})).then((function(t){e.podnice=t}))}},z=g,_=(a("034f"),Object(v["a"])(z,l,f,!1,null,null,null)),y=_.exports,P=a("8c4f"),w=function(){var e=this,t=e.$createElement;e._self._c;return e._m(0)},D=[function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"page-img uvodna"},[a("div",{staticClass:"over-image"},[a("p",[e._v("E-HIVE")])])])}],M=(a("5c82"),{}),x=Object(v["a"])(M,w,D,!1,null,"9148b836",null),E=x.exports,I=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("b-container",{staticClass:"actual-container"},[n("h3",[e._v("Najnovejše meritve")]),n("div",{staticClass:"col col-sm-12 offset-sm-0 col-md-6 offset-md-3"},[e.podnice.length?n("SelectPodnica",{attrs:{podnice:e.podnice},on:{"izbrana-podnica":e.izbranaPodnica}}):e._e()],1),n("b-container",{staticClass:"actual-container"},[n("b-row",[n("b-col",{attrs:{cols:"12",md:"6"}},[e.zadnjeMeritve.length?n("b-table",{attrs:{striped:"",hover:"",items:e.zadnjeMeritve,fields:e.fields}}):e._e()],1),n("b-col",{attrs:{cols:"12",md:"6"}},[e.src?n("div",[n("p",[e._v("Posneto ob: "+e._s(e.varoa_ustvarjena)+" ")]),n("b-img",{attrs:{src:e.src,fluid:"",alt:"Dnevni odpad varoe"}})],1):e.tezave_slika?n("p",[e._v(" Pri nalaganju slike je prišlo do težave. ")]):n("img",{attrs:{src:a("fa5e")}})])],1)],1)],1)},T=[],C=(a("3ca3"),a("ddb0"),a("2b3d"),function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("p",[e._v("Izberite željeno podnico:")]),a("b-form-select",{directives:[{name:"show",rawName:"v-show",value:e.podnice.length,expression:"podnice.length"}],attrs:{options:e.podnice,"value-field":"id","text-field":"naziv"},on:{change:e.spremembaIzbranePodnice},model:{value:e.izbranaPodnica,callback:function(t){e.izbranaPodnica=t},expression:"izbranaPodnica"}})],1)}),Y=[],O={props:{podnice:Array},data:function(){return{izbranaPodnica:-1}},methods:{spremembaIzbranePodnice:function(){this.$emit("izbrana-podnica",this.izbranaPodnica)}},watch:{podnice:function(e,t){0===t.length&&(this.izbranaPodnica=e[0].id,this.spremembaIzbranePodnice())}},created:function(){this.podnice.length&&(this.izbranaPodnica=this.podnice[0].id,this.spremembaIzbranePodnice())}},S=O,V=Object(v["a"])(S,C,Y,!1,null,null,null),$=V.exports,N={components:{SelectPodnica:$},props:{podnice:Array},data:function(){var e=this;return{zadnjeMeritve:[],src:"",tezave_slika:!1,varoa_ustvarjena:"",fields:[{key:"tip.koda",label:"Meritev",formatter:function(t){return e.pridobiImeMeritve(t)}},{key:"vrednost",label:"Vrednost"},{key:"cas_meritve",label:"Čas",formatter:function(e){return s()(e,"YYYY-MM-DDThh:mm:ssTZD").format("DD. MM. YYYY, HH:mm:ss")}}]}},methods:{pridobiZadnjeMeritve:function(e){var t=this;fetch(k.restIp+"/meritve/"+e+"/latest",{method:"get"}).then((function(e){return e.json()})).then((function(e){console.log(e),t.zadnjeMeritve=e}))},pridobiZadnjoVaroo:function(e){var t=this;fetch(k.restIp+"/varoa?filter=podnica.id:EQ:"+e+"&order=cas_meritve DESC&limit=1",{headers:{"Content-Disposition":"inline"},responseType:"blob",method:"get"}).then((function(e){if(e.ok)return t.varoa_ustvarjena=e.headers.get("created"),t.tezave_slika=!1,new Response(e.body);t.tezave_slika=!0})).then((function(e){return e.blob()})).then((function(e){return URL.createObjectURL(e)})).then((function(e){t.src=e})).catch((function(e){console.error(e),t.tezave_slika=!0}))},pridobiImeMeritve:function(e){return"TEMP1"===e?"Zunanja temperatura":"TEMP2"===e?"Notranja temperatura":"VLA1"===e?"Zunanja vlaga":"VLA2"===e?"Notranja vlaga":"TEZA"===e?"Teža":void 0},izbranaPodnica:function(e){this.pridobiZadnjeMeritve(e),this.pridobiZadnjoVaroo(e)}}},H=N,Z=(a("7a3f"),Object(v["a"])(H,I,T,!1,null,"1c4ddd44",null)),A=Z.exports,L=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[e._v(" Graphs ")])},F=[],R={},U=Object(v["a"])(R,L,F,!1,null,null,null),G=(U.exports,function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("b-container",{staticClass:"varoa-container"},[a("h3",[e._v("Dnevni odpad varoe")]),a("div",{staticClass:"col col-sm-12 offset-sm-0 col-md-10 offset-md-1"},[a("div",{staticClass:"col col-12 col-md-6 offset-md-3"},[e.podnice.length?a("SelectPodnica",{attrs:{podnice:e.podnice},on:{"izbrana-podnica":e.izbranaPodnica}}):e._e()],1),a("div",{staticClass:"col col-12 col-md-6 offset-md-3"},[a("b-form-group",{attrs:{label:"Izberi dan:"}},[a("DatePicker",{staticClass:"datepicker",attrs:{format:e.datepicker.format},on:{change:e.izbraniDatum},model:{value:e.datepicker.date,callback:function(t){e.$set(e.datepicker,"date",t)},expression:"datepicker.date"}})],1)],1)]),a("b-container",{staticClass:"varoa-container"},[e.varoaSlike.length?a("b-carousel",{staticStyle:{"text-shadow":"1px 1px 2px #333"},attrs:{id:"carousel",controls:"",indicators:"",background:"#ababab","img-width":"1024","img-height":"480"}},e._l(e.varoaSlike,(function(e,t){return a("b-carousel-slide",{key:t,attrs:{caption:e.ustvarjeno,"img-src":e.src}})})),1):e._e(),a("b-alert",{attrs:{show:e.tezave_slika,variant:"info"}},[e._v(" Prišlo je do težave pri pridobivanju slike dnevnega odpada. Slika verjetno ne obstaja. ")])],1)],1)}),Q=[],q=(a("ac1f"),a("5319"),a("ec45")),B=(a("411c"),a("0176"),{components:{DatePicker:q["default"],SelectPodnica:$},props:{podnice:Array},data:function(){return{limit:1,offset:0,totalCount:100,manjkajocePolje:!1,izbranaPodnicaIndex:-1,varoa_ustvarjena:"",datepicker:{date:null,showSecond:!1,format:"DD. MM. YYYY"},varoaSlike:[],tezave_slika:!1}},methods:{izbranaPodnica:function(e){this.reset(),this.izbranaPodnicaIndex=e,this.pridobiVaroaSlike()},izbraniDatum:function(){this.reset(),this.pridobiVaroaSlike()},pridobiVaroaSlike:function(){this.pridobiVaroo(this.izbranaPodnicaIndex)},reset:function(){this.varoaSlike=[],this.offset=0,this.totalCount=100},encodeDate:function(e){return e.format("YYYY-MM-DDTHH:mm:ssZ").replace("+","%2B")},zacetekDate:function(e){return this.encodeDate(s()(e).startOf("day"))},konecDate:function(e){return this.encodeDate(s()(e).add(1,"day").startOf("day"))},pridobiVaroo:function(e){var t=this;fetch(k.restIp+"/varoa?filter=podnica.id:EQ:"+e+" cas_meritve:GTE:'"+this.zacetekDate(this.datepicker.date)+"' cas_meritve:LT:'"+this.konecDate(this.datepicker.date)+"' &order=cas_meritve DESC&limit=1&offset="+this.offset,{headers:{"Content-Disposition":"inline"},responseType:"blob",method:"get"}).then((function(e){if(t.offset+=1,t.totalCount=e.headers.get("x-total-count"),console.log(t.totalCount),e.ok)return t.varoa_ustvarjena=e.headers.get("created"),t.tezave_slika=!1,new Response(e.body);throw t.tezave_slika=!0,new Error("Težave pri pridobivanju slike")})).then((function(e){return e.blob()})).then((function(e){return URL.createObjectURL(e)})).then((function(e){var a={src:e,ustvarjeno:t.varoa_ustvarjena};t.varoaSlike.push(a),t.offset<t.totalCount&&t.pridobiVaroaSlike()})).catch((function(e){console.error(e),t.tezave_slika=!0}))}},created:function(){this.datepicker.date=s()().toDate()}}),J=B,K=(a("504f"),Object(v["a"])(J,G,Q,!1,null,"8c6d0664",null)),W=K.exports,X=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[e._v(" Traffic ")])},ee=[],te={},ae=Object(v["a"])(te,X,ee,!1,null,null,null),ne=ae.exports,re=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("b-container",{staticClass:"measurements-container"},[a("h3",[e._v("Vse meritve")]),a("div",{staticClass:"col col-sm-12 offset-sm-0 col-md-10 offset-md-1"},[a("b-alert",{attrs:{show:e.manjkajocePolje,variant:"danger"}},[e._v(" Izpolnite vsa polja! ")]),a("b-form",{on:{submit:function(t){return t.preventDefault(),e.search(t)}}},[a("b-form-group",{attrs:{id:"input-group-podnica",label:"Izberi iskano podnico:","label-for":"podnica"}},[a("b-form-select",{directives:[{name:"show",rawName:"v-show",value:e.podnice.length,expression:"podnice.length"}],attrs:{options:e.podnice,"value-field":"id","text-field":"naziv"},model:{value:e.form.indeksIzbranePodnice,callback:function(t){e.$set(e.form,"indeksIzbranePodnice",t)},expression:"form.indeksIzbranePodnice"}})],1),e.tipi.length?a("b-form-group",{attrs:{id:"input-group-tip",label:"Izberi tip meritve:"}},[a("b-form-checkbox-group",{attrs:{id:"checkboxes-tip"},model:{value:e.form.checked,callback:function(t){e.$set(e.form,"checked",t)},expression:"form.checked"}},e._l(e.tipi,(function(t){return a("b-form-checkbox",{key:t.koda,attrs:{value:t.koda}},[e._v(" "+e._s(t.ime)+" ")])})),1)],1):e._e(),a("div",{staticClass:"row"},[a("div",{staticClass:"col col-12 col-md-6"},[a("b-form-group",{attrs:{label:"Od:"}},[a("DatePicker",{staticClass:"datepicker",attrs:{type:"datetime","show-second":e.datepicker.showSecond,format:e.datepicker.format},model:{value:e.datepicker.datetimeFrom,callback:function(t){e.$set(e.datepicker,"datetimeFrom",t)},expression:"datepicker.datetimeFrom"}})],1)],1),a("div",{staticClass:"col col-12 col-md-6"},[a("b-form-group",{attrs:{label:"Do:"}},[a("DatePicker",{staticClass:"datepicker",attrs:{type:"datetime","show-second":e.datepicker.showSecond,format:e.datepicker.format},model:{value:e.datepicker.datetimeTo,callback:function(t){e.$set(e.datepicker,"datetimeTo",t)},expression:"datepicker.datetimeTo"}})],1)],1)]),a("b-button",{attrs:{type:"submit",variant:"primary"}},[e._v("Poišči meritve")])],1)],1),a("b-container",{staticClass:"measurements-container"},[a("b-row",[a("b-col",{attrs:{cols:"12"}},[e.meritve.length?a("b-table",{attrs:{striped:"",hover:"",items:e.meritve,fields:e.fields}}):e.vsajEnoPridobivanjeMeritev?a("p",[e._v(" Nobena meritev ne ustreza iskalni zahtevi ")]):e._e()],1)],1)],1),e.meritve.length?a("scroll-loader",{directives:[{name:"show",rawName:"v-show",value:e.naloziVec,expression:"naloziVec"}],attrs:{"loader-method":e.pridobiMeritve,"loader-enable":e.naloziVec}}):e._e()],1)},ie=[],oe={components:{DatePicker:q["default"]},props:{podnice:Array},data:function(){var e=this;return{meritve:[],tipi:[],limit:10,offset:0,naloziVec:!0,totalCount:100,vsajEnoPridobivanjeMeritev:!1,manjkajocePolje:!1,datepicker:{datetimeFrom:null,datetimeTo:null,showSecond:!1,format:"DD. MM. YYYY, HH:mm"},form:{indeksIzbranePodnice:-1,checked:[]},fields:[{key:"tip.koda",label:"Meritev",formatter:function(t){return e.pridobiImeMeritve(t)}},{key:"vrednost",label:"Vrednost"},{key:"cas_meritve",label:"Čas",formatter:function(e){return s()(e,"YYYY-MM-DDTHH:mm:ssTZD").format("DD. MM. YYYY, HH:mm:ss")}}]}},methods:{pridobiMeritve:function(){var e=this;console.log(this.iskalniNiz()),fetch(k.restIp+"/meritve?"+this.iskalniNiz()+"&limit="+this.limit+"&offset="+this.offset+"&order=cas_meritve DESC",{method:"get"}).then((function(t){return e.totalCount=parseInt(t.headers.get("x-total-count")),t.json()})).then((function(t){console.log(t),e.vsajEnoPridobivanjeMeritev=!0,e.offset+=e.limit,e.meritve.push.apply(e.meritve,t),e.meritve.length===e.totalCount&&(e.naloziVec=!1)}))},pridobiImeMeritve:function(e){return"TEMP1"===e?"Zunanja temperatura":"TEMP2"===e?"Notranja temperatura":"VLA1"===e?"Zunanja vlaga":"VLA2"===e?"Notranja vlaga":"TEZA"===e?"Teža":"VAROA"===e?"Varoa":void 0},izbranaPodnica:function(e){this.form.indeksIzbranePodnice=e,this.pridobiMeritve()},iskalniNiz:function(){return"filter=podnica.id:EQ:"+this.form.indeksIzbranePodnice+" tip.koda:IN:["+this.form.checked+"] cas_meritve:LTE:'"+this.encodeDate(this.datepicker.datetimeTo)+"' cas_meritve:GTE:'"+this.encodeDate(this.datepicker.datetimeFrom)+"'"},encodeDate:function(e){return s()(e).format("YYYY-MM-DDTHH:mm:ssZ").replace("+","%2B")},search:function(){0===this.form.checked.length||this.indeksIzbranePodnice<0||null===this.datepicker.datetimeFrom||null===this.datepicker.datetimeTo?this.manjkajocePolje=!0:(this.manjkajocePolje=!1,this.offset=0,this.meritve=[],this.pridobiMeritve())}},created:function(){var e=this;this.datepicker.datetimeFrom=s()().subtract(30,"days").toDate(),this.datepicker.datetimeTo=s()().toDate(),fetch(k.restIp+"/tipi",{method:"get"}).then((function(e){return e.json()})).then((function(t){var a=t;for(var n in a)a[n].ime=e.pridobiImeMeritve(a[n].koda);e.tipi=a}))}},se=oe,ce=(a("d253"),Object(v["a"])(se,re,ie,!1,null,"29fde1ba",null)),de=ce.exports,le=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[e._v(" Settings ")])},fe=[],ue={},be=Object(v["a"])(ue,le,fe,!1,null,null,null),me=be.exports;n["default"].use(P["a"]);var pe=[{path:"/",name:"E-HIVE",component:E},{path:"/aktualno",name:"Aktualno",component:A},{path:"/meritve",name:"Meritve",component:de},{path:"/varoa",name:"Varoa",component:W},{path:"/promet",name:"Promet",component:ne},{path:"/nastavitve",name:"Nastavitve",component:me}],ve=new P["a"]({routes:pe}),he=ve;a("f9e3"),a("2dd8");n["default"].use(r["a"]),n["default"].use(i["a"]),n["default"].use(d.a),n["default"].config.productionTip=!1,n["default"].prototype.moment=s.a,new n["default"]({router:he,render:function(e){return e(y)}}).$mount("#app")},"5c82":function(e,t,a){"use strict";var n=a("dbf8"),r=a.n(n);r.a},"5fb6":function(e,t,a){},6571:function(e,t,a){},"72bf":function(e,t,a){"use strict";var n=a("b32f"),r=a.n(n);r.a},"7a3f":function(e,t,a){"use strict";var n=a("6571"),r=a.n(n);r.a},"85ec":function(e,t,a){},b32f:function(e,t,a){},cf80:function(e,t,a){},d253:function(e,t,a){"use strict";var n=a("cf80"),r=a.n(n);r.a},dbf8:function(e,t,a){},fa5e:function(e,t,a){e.exports=a.p+"img/loader.3151441a.gif"}});
//# sourceMappingURL=app.13d321ac.js.map