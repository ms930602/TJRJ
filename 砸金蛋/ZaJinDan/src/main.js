// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import Vuex from 'vuex'
Vue.use(Vuex)
import stores from './store/store.js'
import App from './App'
import router from './router'
import mixin from './mixin/mixin.js'
import {Layout} from 'vue-ydui/dist/lib.rem/layout';
import { Confirm, Alert, Toast, Notify, Loading } from 'vue-ydui/dist/lib.rem/dialog';
import {Icons} from 'vue-ydui/dist/lib.rem/icons';
Vue.component(Icons.name, Icons);
Vue.prototype.$dialog = {
    confirm: Confirm,
    alert: Alert,
    toast: Toast,
    notify: Notify,
    loading: Loading,
};

const store = new Vuex.Store(stores)
import 'vue-ydui/dist/ydui.base.css';
Vue.component(Layout.name, Layout)
Vue.config.productionTip = false 
//设置为 false 以阻止 vue 在启动时生成生产提示。
//# sourceMappingURL=auto-size.js.map
/* eslint-disable no-new */
document.title=config.title;
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>',
  mixins: [mixin],
})
