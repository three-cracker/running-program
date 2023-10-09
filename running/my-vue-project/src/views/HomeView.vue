<template>
  <div class="container">
    <el-container style="height: 100%;display: flex;flex-direction: column">
      <el-main style="height: 8.5rem;padding: 0;margin: 0">
        <router-view/>
      </el-main>
      <el-footer style="height: 1.5rem;display: flex;align-items: flex-end;justify-content: flex-end;padding: 0">
        <template>
          <el-tabs v-model="activeName" @tab-click="handleClick">
            <el-tab-pane v-for="tab in tabs" :label="tab.label" :name="tab.name" :key="tab.name" style="flex: 1">
              <router-view :key="tab.name"></router-view>
            </el-tab-pane>
          </el-tabs>
        </template>
      </el-footer>
    </el-container>

  </div>
</template>

<script>
// @ is an alias to /src

export default {
  name: 'HomeView',
  components: {

  },
  data() {
    return {

      user: localStorage.getItem("current-user") ? JSON.parse(localStorage.getItem("current-user")) : {},
      activeName: 'home',
      tabs: [
        { label: '首页', name: 'home' },
        { label: '排行榜', name: 'rank' },
        { label: '我的', name: 'my' }
      ]
    };
  },
  methods: {
    handleClick(tab, event) {
      this.$router.push({ path: tab.name });
    },
  },
  mounted() {
    this.activeName = this.$router.currentRoute.name
    // console.log(this.$router.currentRoute.path) /rank
    // console.log(this.$router.currentRoute.name) rank
    // console.log(this.$router.currentRoute.fullPath) /rank
    // console.log(this.$route.path) /rank
    // console.log(this.$route.fullPath) /rank
  },
  created() {
  }
}
</script>
<style>
.el-tabs__content{
  display: none;
}
.el-tabs__nav{
  width: 100%;
  display: flex;
}
.el-tabs__item{
  flex: 1;
}
.el-tabs{
  width: 100%;
  margin: 0;
  /*padding: 0.2rem 0;*/
}
.el-tabs__item{
  font-size: 0.5rem !important;
}
.el-tabs__active-bar{
  top: 0;
}
.el-tabs__nav-wrap::after {
  top: 0;
}
.el-tabs__header{
  margin: 0 !important;
}
.el-tabs__item{
  display: flex;
  align-items: center;
  justify-content: center;
}
.el-tabs__nav{
  padding:0.2rem 0;
}
/*#app > div > section > footer > div > div.el-tabs__header.is-top > div > div > div{*/
/*  width: 10rem;*/
/*}*/
/*.is-top{*/
/*  flex: 1;*/
/*}*/
</style>
