<template>
    <div id="app">
        <router-view/>
        <MyTabBar v-if="!($route.path==='/productDetail')"/>
    </div>
</template>
<script>
    import MyTabBar from "./components/MyTabBar";

    export default {
        components: {MyTabBar}
    }
</script>
<style>
    #app {
        font-family: Avenir, Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        background: #fefeff;
        min-height: 100%;
    }

    html {
        font-size: 100px;
    }

    body {
        font-size: .14rem;
    }

    html, body {
        height: 100%;
    }
</style>
