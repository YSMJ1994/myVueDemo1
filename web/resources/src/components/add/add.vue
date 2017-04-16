<template>
    <div class="yaheifont" style="margin-left: 100px;margin-top: 100px;">
        <table>
            <tr>
                <td><span>用户名:</span></td>
                <td><el-input v-model="user.username" placeholder="请输入用户名" style="width: 300px;margin-left: 10px;"></el-input></td>
            </tr>
            <tr>
                <td><span>密码:</span></td>
                <td><el-input v-model="user.password" placeholder="请输入密码" style="width: 300px;margin-left: 10px;"></el-input></td>
            </tr>
            <tr>
                <td><el-button type="primary" @click="addUser">添加用户</el-button></td>
            </tr>
        </table>
    </div>
</template>

<script>
    import { bus } from '../../bus.js'
    export default {
        data() {
            return {
                user:{
                    id: 1,
                    create_time: '',
                    username:'',
                    password:''
                }
            }
        },
        methods:{
            addUser:function() {
                this.$http.post('http://localhost:8080/app1/addUser.action',JSON.stringify(this.user)).then(function() {
                    bus.$emit('openUserList');
                })
            }
        }
    }
</script>

<style>
    .yaheifont *{
        font-family:'Microsoft YaHei',fantasy;
        font-size: Small;
    }
</style>