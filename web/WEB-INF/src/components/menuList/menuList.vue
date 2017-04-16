<template>
    <el-row class="tac">
        <el-col :span="4">
            <el-menu default-active="2" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose" theme="dark">
              <el-submenu index="1">
                <template slot="title"><i class="el-icon-message"></i>管理</template>
                    <el-menu-item index="1-1" @click="openUserList">用户</el-menu-item>
              </el-submenu>
            </el-menu>
        </el-col>
        <el-col :span="20">
            <keep-alive>
                <component :is="currentView"></component>
            </keep-alive>
        </el-col>
    </el-row>
</template>

<script>
    import Vue from 'vue'
    import Element from 'element-ui'
    import 'element-ui/lib/theme-default/index.css'
    import page from '../page/page.vue'
    import { bus } from '../../bus.js'
    Vue.use(Element)

    export default {
        data() {
            return {
                currentView:''
            }
        },
        methods:{
            handleOpen(key, keyPath) {
                console.log(key, keyPath);
            },
            handleClose(key, keyPath) {
                console.log(key, keyPath);
            },
            openUserList:function() {
                bus.$emit('openUserList');
                this.currentView='page';
            }
        },
        components:{
            'page':page
        }
    }
</script>