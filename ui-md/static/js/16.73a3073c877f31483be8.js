webpackJsonp([16],{"85qg":function(e,t,n){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var l=n("9IBV"),a={data:function(){return{list:null,listLoading:!0}},filters:{statusFilter:function(e){return{published:"success",draft:"gray",deleted:"danger"}[e]}},created:function(){this.fetchData()},methods:{fetchData:function(){var e=this;this.listLoading=!0,Object(l.a)().then(function(t){console.log("res"+t.data.userList),e.list=t.data.userList,e.listLoading=!1})}}},s={render:function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"app-container"},[n("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.listLoading,expression:"listLoading"}],attrs:{data:e.list,"element-loading-text":"Loading",border:"",fit:"","highlight-current-row":""}},[n("el-table-column",{attrs:{label:"ID",width:"95",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v("\n        "+e._s(t.row.userId)+"\n      ")]}}])}),e._v(" "),n("el-table-column",{attrs:{label:"用户名",width:"110",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[n("span",[e._v(e._s(t.row.userAccountName))])]}}])}),e._v(" "),n("el-table-column",{attrs:{label:"昵称",width:"110",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[n("span",[e._v(e._s(t.row.userName))])]}}])}),e._v(" "),n("el-table-column",{attrs:{label:"性别",width:"110",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[n("span",[e._v(e._s(t.row.userSex))])]}}])}),e._v(" "),n("el-table-column",{attrs:{label:"邮箱",width:"150",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[n("span",[e._v(e._s(t.row.userEmail))])]}}])}),e._v(" "),n("el-table-column",{attrs:{label:"所在位置",width:"150",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[n("span",[e._v(e._s(t.row.userLocation))])]}}])}),e._v(" "),n("el-table-column",{attrs:{label:"电话号码",width:"150",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[n("span",[e._v(e._s(t.row.userPhoneNumber))])]}}])}),e._v(" "),n("el-table-column",{attrs:{label:"注册时间",width:"150",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[n("span",[e._v(e._s(t.row.userGmtCreate))])]}}])}),e._v(" "),n("el-table-column",{attrs:{label:"最后登录",width:"150",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[n("span",[e._v(e._s(t.row.userLastLogin))])]}}])}),e._v(" "),n("el-table-column",{attrs:{label:"访问次数",width:"110",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[n("span",[e._v(e._s(t.row.userLoginCount))])]}}])}),e._v(" "),n("el-table-column",{attrs:{label:"启用状态",width:"110",align:"center","class-name":"status-col"},scopedSlots:e._u([{key:"default",fn:function(t){return[n("el-tag",{attrs:{type:e._f("statusFilter")(t.row.isUserDeleted)}},[e._v(e._s(t.row.isUserDeleted))])]}}])}),e._v(" "),n("el-table-column",{attrs:{label:"权限",width:"100",align:"center","class-name":"status-col"},scopedSlots:e._u([{key:"default",fn:function(t){return[n("el-tag",{attrs:{type:e._f("statusFilter")(t.row.userRole)}},[e._v(e._s(t.row.userRole))])]}}])}),e._v(" "),n("el-table-column",{attrs:{label:"Actions","min-width":"200",align:"center",prop:"created_at"},scopedSlots:e._u([{key:"default",fn:function(t){return[n("i",{staticClass:"el-icon-time"}),e._v(" "),n("router-link",[n("el-button",{attrs:{type:"primary",size:"small",icon:"el-icon-edit"}},[e._v("Edit")])],1)]}}])})],1)],1)},staticRenderFns:[]},r=n("VU/8")(a,s,!1,null,null,null);t.default=r.exports}});