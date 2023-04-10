import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const store = new Vuex.Store({
	state: {
		uerInfo: {},
		hasLogin: false,
		roleId: 0,
		classinfo: {
			classid: '',
			Name: '',
			StudentNumber: '',
			Manage:'Delete'
		}
	},
	mutations: {
		setNewClass(state, classinfo) {
			// state.classinfo.classid = classinfo.id
			// state.classinfo.Name = classinfo.name
			// state.classinfo.studentNumber = classinfo.studentNumber
			// console.log(classinfo)
			state.classinfo.classid = classinfo.id
			state.classinfo.Name = classinfo.name
			state.classinfo.StudentNumber = classinfo.studentNumber
			// console.log(state.classinfo)
			uni.setStorageSync('classid', classinfo.id)
			uni.setStorageSync('Name', classinfo.name)
			uni.setStorageSync('studentNumber', classinfo.studentNumber)
		},
		setClassId(state, classinfo) {
			state.classinfo.classid = classinfo.id
			state.classinfo.Name = classinfo.Name
			uni.setStorageSync('classid', classinfo.id)
			uni.setStorageSync('Name', classinfo.Name)
			// uni.setStorageSync('classinfo',classinfo)
		},
		login(state, provider) {
			state.hasLogin = true
			state.uerInfo.token = provider.token
			state.uerInfo.userName = provider.user_name
			uni.setStorage({
				key: 'uerInfo',
				data: provider
			})
		},
		setRoleId(state, data) {
			state.roleId = data;
			uni.setStorageSync('roleId', data)
			console.log("setRoleId:", data)
		},
		logout(state) {
			state.hasLogin = false
			state.uerInfo = {}
			uni.removeStorage({
				key: 'uerInfo',
				key: 'hasLogin',
				key: 'roleId'

			});
		}
	}
})

export default store
