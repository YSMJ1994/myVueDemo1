<template>
    <div>
        <my-head style="margin:0px;padding: 0px;"></my-head>
        <my-menu-list style="margin-top:0px;margin-left: 0px;"></my-menu-list>
    </div>
</template>

<script>
    import myHead from './components/head/head.vue'
    import menuList from './components/menuList/menuList.vue'
    import { bus } from './bus.js'

    export default {
        components:{
            'my-head':myHead,
            'my-menu-list':menuList
        }
    }
</script>