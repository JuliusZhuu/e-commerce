<template>
  <!--首页品牌制造商直供-->
  <div class="brand">
    <h4>品牌制造商直供</h4>
    <van-grid :column-num="2" :gutter="0" :border="false">
      <van-grid-item v-for="(item,index) in brandList" :key="index">
        <template #default>
          <div>
            <van-image
                width="190px"
                height="100"
                fit="fill"
                :src="item.picUrl"
            />
            <span class="name">{{ item.name }}</span>
            <span class="money">￥{{ item.floorPrice }}</span>
          </div>
        </template>
      </van-grid-item>
    </van-grid>
  </div>
</template>

<script>
export default {
  name: "MyBrand",
  props: ['brandList'],
  data() {
    return {}
  }
}
</script>

<style lang="less" scoped>
.brand {
  text-align: center;
  font-weight: bold;

  .name {
    position: absolute;
    top: 20%;
    left: 30%;
    color: red;
  }

  .money {
    position: absolute;
    top: 40%;
    left: 30%;
    color: red;
  }
}

/deep/ .van-grid-item__content {
  padding: .02rem .02rem;
}
</style>