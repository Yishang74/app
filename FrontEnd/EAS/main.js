import Vue from 'vue'
import App from './App'
import store from './store'
import uView from "uview-ui";
import axios from 'axios'
Vue.config.productionTip = false
Vue.use(uView);
App.mpType = 'app'

Vue.prototype.$serverUrl = 'https://www.dcloud.io/demo'
Vue.prototype.$store = store

// create an axios instance
const service = axios.create({
    baseURL: 'http://127.0.0.1:8080', // url = base url + request url
    withCredentials: false, // send cookies when cross-domain requests
    // timeout: 5000, // request timeout
    crossDomain: true
})

Vue.prototype.$axios = service

const app = new Vue({
	...App,
	store,
    
})
app.$mount()
