import Vue from 'vue'
import App from './App'
import store from './store'
import uView from "uview-ui";
Vue.config.productionTip = false
Vue.use(uView);
App.mpType = 'app'

Vue.prototype.$serverUrl = 'https://www.dcloud.io/demo'
Vue.prototype.$store = store

const app = new Vue({
	...App,
	store,
    
})
app.$mount()
