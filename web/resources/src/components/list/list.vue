<template>
    <div>
        <el-button type="primary" style="margin-right: 20px;float: left;" @click.native="addUser">添加</el-button>
        <el-table
                :data="tabledata"
                stripe
                style="margin-left: 60px;margin-top:30px;width: 80%;" fit>
            <el-table-column
                    prop="username"
                    label="用户名" align="center" class-name="yaheifont">
            </el-table-column>
            <el-table-column
                    prop="password"
                    label="密码" align="center" class-name="yaheifont">
            </el-table-column>
            <el-table-column
                    prop="create_time"
                    label="创建时间" align="center" class-name="yaheifont">
            </el-table-column>
            <el-table-column
                    label="操作" align="center" class-name="yaheifont">
                <template scope="scope">
                    <el-button size="small" type="primary" @click.native="editUser(scope.row.id)"><i class="el-icon-edit"></i></el-button>
                    <el-button size="small" type="primary" @click.native="deleteUser(scope.row.id)"><i class="el-icon-delete"></i></el-button>
                </template>
            </el-table-column>
        </el-table>
    </div>

</template>

<script>
    import { bus } from '../../bus.js'
    export default {
        props:['tabledata'],
        methods:{
            addUser:function() {
                this.$emit('add-user');
            },
            editUser:function(id) {
                this.$emit('edit-user',id);
            },
            deleteUser:function(id) {
                this.$http.post('http://localhost:8080/app1/deleteUserById.action',JSON.stringify({id:id})).then(function() {
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