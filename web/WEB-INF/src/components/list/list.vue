<template>
    <div>
        <el-button type="primary" style="margin-left: 801px;" @click.native="addUser">添加</el-button>
        <el-table
                :data="tableData"
                stripe
                style="margin: 1px 60px;width: 801px;">
            <el-table-column
                    prop="username"
                    label="用户名"
                    width="200" align="center" class-name="yaheifont">
            </el-table-column>
            <el-table-column
                    prop="password"
                    label="密码"
                    width="200" align="center" class-name="yaheifont">
            </el-table-column>
            <el-table-column
                    prop="create_time"
                    label="创建时间"
                    width="250" align="center" class-name="yaheifont">
            </el-table-column>
            <el-table-column
                    label="操作"
                    width="150" align="center" class-name="yaheifont">
                <template scope="scope">
                    <el-button size="small" type="primary" @click.native="editUser(scope.row.id)"><i class="el-icon-edit"></i></el-button>
                    <el-button size="small" type="primary" @click.native="deleteUser(scope.row.id)"><i class="el-icon-delete"></i></el-button>
                </template>
            </el-table-column>
        </el-table>
    </div>

</template>

<script>
    import Vue from 'vue'
    import 'element-ui/lib/theme-default/index.css'
    import ElementUi from 'element-ui'
    Vue.use(ElementUi)

    export default {
        data() {
            return {
                tableData:[
                    {'username':'sober1','password':'sober1','create_time':'2017-4-14 14:28','id':1},
                    {'username':'sober2','password':'sober2','create_time':'2017-4-14 14:28','id':2},
                    {'username':'sober3','password':'sober3','create_time':'2017-4-14 14:28','id':3},
                    {'username':'sober4','password':'sober4','create_time':'2017-4-14 14:28','id':4}
                ]
            }
        },
        methods:{
            addUser:function() {
                this.$emit('add-user');
            },
            editUser:function(id) {
                this.$emit('edit-user',id);
            },
            deleteUser:function(id) {
                this.$emit('delete-user',id);
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