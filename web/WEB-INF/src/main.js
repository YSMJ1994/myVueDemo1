import Vue from 'vue'
import App from './app.vue'

var bus = new Vue();

new Vue({
	bus,
	template: '<App/>',
	components: {
		App
	}
}).$mount('#app')