<template>
    <!--首页频道-->
    <div>
        <van-grid :column-num="5">
            <van-grid-item v-for="(item,index) in channel" :icon="item.iconUrl"
                           :text="item.name" :key="index"/>
        </van-grid>
    </div>
</template>

<script>
    export default {
        name: "MyChannel",
        props: ['channel']
    }
</script>

<style scoped>

</style>