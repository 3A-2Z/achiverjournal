(this.webpackJsonpachiverjournal=this.webpackJsonpachiverjournal||[]).push([[0],{150:function(t,e,n){},151:function(t,e,n){},156:function(t,e,n){},467:function(t,e,n){"use strict";n.r(e);var c=n(2),r=n(1),a=n.n(r),s=n(22),i=n.n(s),o=(n(150),n(26)),l=n.p+"static/media/github-brands.e2f07326.svg",u=(n(151),n(29));var j=function(){var t=Object(r.useState)([]),e=Object(o.a)(t,2),n=e[0],a=e[1];return Object(r.useEffect)((function(){fetch("http://achieverjournal-env.eba-2ezdz2u2.us-east-1.elasticbeanstalk.com//api/v1/entries").then((function(t){return t.json()})).then((function(t){a(t)}))}),[]),Object(c.jsx)("div",{className:"App",children:Object(c.jsxs)("header",{className:"App-header",children:[Object(c.jsx)("a",{href:"https://github.com/3A-2Z",children:Object(c.jsx)("img",{src:l,class:"fa-github"})}),Object(c.jsxs)("div",{class:"container",children:[Object(c.jsx)(u.b,{to:"/entry",children:Object(c.jsx)("button",{class:"new-entry",children:"Begin Writing Towards Your Goals!"})}),Object(c.jsx)("h2",{children:"Your Journal Entries!"}),Object(c.jsxs)("ul",{class:"responsive-table",children:[Object(c.jsxs)("li",{class:"table-header",children:[Object(c.jsx)("div",{class:"col col-1",children:"Entry Title"}),Object(c.jsx)("div",{class:"col col-2",children:"Date"}),Object(c.jsx)("div",{class:"col col-3",children:"Entry Link"})]}),n.map((function(t){return Object(c.jsxs)("li",{class:"table-row",children:[Object(c.jsx)("div",{class:"col col-1",children:t.title}),Object(c.jsx)("div",{class:"col col-2",children:t.date}),Object(c.jsx)("div",{class:"col col-3",children:Object(c.jsx)(u.b,{to:"/entry/".concat(t.ID),children:"Go to Entry!"})})]})}))]})]})]})})},h=n(35),b=n.n(h),d=n(59),f=n(4),x=(n(156),n(85)),p=n.n(x);n(173);var O=function(){var t=window.location.pathname.split("/"),e=" ";e=3===t.length?t[2]:t[1];var n=Object(f.e)(),a=Object(r.useState)(""),s=Object(o.a)(a,2),i=s[0],l=s[1],j=Object(r.useState)("entry"===e),h=Object(o.a)(j,2),x=h[0],O=h[1],v=Object(r.useState)(""),g=Object(o.a)(v,2),y=g[0],m=g[1],k=Object(r.useState)(""),w=Object(o.a)(k,2),C=w[0],E=w[1],S=Object(r.useState)(""),T=Object(o.a)(S,2),A=T[0],D=T[1],I=Object(r.useState)(""),L=Object(o.a)(I,2),B=(L[0],L[1]);function F(t){l((function(e){return t.text})),m((function(e){return t.title})),E((function(e){return t.date})),D((function(e){return t.entryTags}))}function P(){return(P=Object(d.a)(b.a.mark((function t(c){return b.a.wrap((function(t){for(;;)switch(t.prev=t.next){case 0:if({ID:"",title:y,text:i},c.preventDefault(),"entry"!==e||!x){t.next=10;break}if(0!==y.length&&0!==i.length){t.next=6;break}return alert("Please fill out the entry in full"),t.abrupt("return");case 6:return t.next=8,p()({method:"post",url:"http://journalentry-env.eba-xri3y22g.us-east-1.elasticbeanstalk.com/api/v1/addentry",data:{ID:"",title:y,text:i},headers:{"Content-Type":"application/json","Access-Control-Allow-Origin":"*"}}).then(function(){var t=Object(d.a)(b.a.mark((function t(e){return b.a.wrap((function(t){for(;;)switch(t.prev=t.next){case 0:return t.abrupt("return",e.data);case 1:case"end":return t.stop()}}),t)})));return function(e){return t.apply(this,arguments)}}()).then(function(){var t=Object(d.a)(b.a.mark((function t(c){return b.a.wrap((function(t){for(;;)switch(t.prev=t.next){case 0:return B((function(t){return c})),e=c,console.log(c),t.next=5,fetch("http://journalentry-env.eba-xri3y22g.us-east-1.elasticbeanstalk.com/".concat(c)).then((function(t){return t.json()})).then((function(t){return F(t)}));case 5:n.push("/entry/".concat(c));case 6:case"end":return t.stop()}}),t)})));return function(e){return t.apply(this,arguments)}}()).catch((function(t){return console.log(t)}));case 8:t.next=16;break;case 10:if(!x){t.next=16;break}if(0!==y.length&&0!==i.length){t.next=14;break}return alert("Please fill out the entry in full"),t.abrupt("return");case 14:return t.next=16,p.a.put("http://journalentry-env.eba-xri3y22g.us-east-1.elasticbeanstalk.com/put/".concat(e),{text:i,title:y},{headers:{"Content-Type":"application/json","Access-Control-Allow-Origin":"*"}}).then((function(t){console.log(t),fetch("http://journalentry-env.eba-xri3y22g.us-east-1.elasticbeanstalk.com/".concat(e)).then((function(t){return t.json()})).then((function(t){return F(t)}))})).catch((function(t){return console.log(t)}));case 16:O((function(t){return!t}));case 17:case"end":return t.stop()}}),t)})))).apply(this,arguments)}return Object(r.useEffect)((function(){return fetch("http://journalentry-env.eba-xri3y22g.us-east-1.elasticbeanstalk.com/".concat(e)).then((function(t){return t.json()})).then((function(t){return F(t)}))}),[]),Object(c.jsxs)("form",{children:[x?Object(c.jsxs)("div",{children:[Object(c.jsx)("h1",{children:Object(c.jsxs)("div",{class:"question",children:[Object(c.jsx)("input",{class:"question",type:"text",value:y,onChange:function(t){m((function(e){return t.target.value})),console.log(y)},required:!0}),Object(c.jsx)("label",{children:"Entry Title"})]})}),Object(c.jsxs)("h3",{children:["Last Updated:",C]}),Object(c.jsx)("div",{class:"text",children:Object(c.jsx)("textarea",{type:"text",value:i,onChange:function(t){l((function(e){return t.target.value})),console.log(i)}})})]}):Object(c.jsxs)("div",{children:[Object(c.jsx)("h1",{children:y}),Object(c.jsxs)("h3",{children:["Last Updated:",C]}),Object(c.jsx)("p",{children:i})]}),Object(c.jsx)("div",{children:Object(c.jsxs)("span",{children:[Object(c.jsx)("h1",{children:"What's on your mind!"}),Object(c.jsx)("br",{}),Object(c.jsx)("p",{children:A})]})}),Object(c.jsx)("button",{onClick:function(t){return P.apply(this,arguments)},children:"Edit"}),Object(c.jsx)("br",{}),Object(c.jsx)(u.b,{to:"/journal",children:Object(c.jsx)("button",{children:"Back to Entries"})})]})},v=function(t){t&&t instanceof Function&&n.e(3).then(n.bind(null,468)).then((function(e){var n=e.getCLS,c=e.getFID,r=e.getFCP,a=e.getLCP,s=e.getTTFB;n(t),c(t),r(t),a(t),s(t)}))};i.a.render(Object(c.jsx)(a.a.StrictMode,{children:Object(c.jsxs)(u.a,{children:[Object(c.jsx)(f.a,{path:"/journal",component:j}),Object(c.jsx)(f.a,{path:"/entry",component:O})]})}),document.getElementById("root")),v()}},[[467,1,2]]]);
//# sourceMappingURL=main.a58bfd4e.chunk.js.map