<template>
    <div>
        <component :is="currentView" :pid="id" :tabledata="tableData" @add-user="addUser" @edit-user="editUser"></component>
    </div>
</template>

<script>
    import list from '../list/list.vue'
    import add from '../add/add.vue'
    import edit from '../edit/edit.vue'
    import { bus } from '../../bus.js'

    export default {
        data() {
            return {
                currentView:'list',
                id:'',
                tableData:[]
            }
        },
        created:function() {
            this.$http.get('http://localhost:8080/app1/queryUserList.action').then(function(response) {
                this.tableData = response.body;
                alert(response.body);
                alert(this.tableData);
            });
            bus.$on('openUserList',function(){
                this.$http.get('http://localhost:8080/app1/queryUserList.action').then(function(response) {
                    this.tableData = response.body;
                });
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