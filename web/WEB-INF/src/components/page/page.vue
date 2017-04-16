<template>
    <div>
        <keep-alive>
            <component :is="currentView" :id="id" @add-user="addUser" @edit-user="editUser" @list="showList"></component>
        </keep-alive>
    </div>
</template>

<script>
    import Vue from 'vue'
    import 'element-ui/lib/theme-default/index.css'
    import ElementUi from 'element-ui'
    import list from '../list/list.vue'
    import add from '../add/add.vue'
    import edit from '../edit/edit.vue'
    import { bus } from '../../bus.js'
    Vue.use(ElementUi)

    export default {
        data() {
            return {
                currentView:'list',
                id:''
            }
        },
        created:function() {
            bus.$on('openUserList',function(){
                this.currentView='list';
            }.bind(this));
        },
        methods:{
            addUser:function(id) {
                this.id=id;
                this.currentView='add'
            },
            editUser:function(id) {
                this.id=id;
                this.currentView='edit'
            },
            showList:function() {
                this.currentView='list'
            }
        },
        components:{
            'list':list,
            'add':add,
            'edit':edit
        }
    }
</script>

<style>
    .yaheifont *{
        font-family:'Microsoft YaHei',fantasy;
        font-size: Small;
    }
</style>