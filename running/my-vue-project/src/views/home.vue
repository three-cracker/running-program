<template>
  <div class="main">
    <template>
      <el-button
          plain
          @click="open2">
        不会自动关闭
      </el-button>
    </template>
    <template>
      <el-carousel :interval="5000" arrow="always">
        <el-carousel-item v-for="item in 4" :key="item">
          <h3>{{ item }}</h3>
        </el-carousel-item>
      </el-carousel>
    </template>
    <el-main style="display: flex;align-items: center;justify-content: center;flex-direction: column">
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>活动一</span>
          <el-button style="float: right; padding: 3px 0" type="text">未参加</el-button>
        </div>
        <div class="text item">活动内容</div>
<!--        <div v-for="o in 4" :key="o" class="text item">-->
<!--          {{'列表内容 ' + o }}-->
<!--        </div>-->
      </el-card>
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>活动二</span>
          <el-button style="float: right; padding: 3px 0" type="text">未参加</el-button>
        </div>
        <div class="text item">活动内容</div>
<!--        <div v-for="o in 4" :key="o" class="text item">-->
<!--          {{'列表内容 ' + o }}-->
<!--        </div>-->
      </el-card>
      <div class="sign" @click="handleSign">打卡</div>
    </el-main>
  </div>
</template>

<script>
export default {
  name: "home",
  data(){
    return{

    }
  },
  methods: {
    handleSign() {
      let userInfo = JSON.parse(localStorage.getItem("user"));
      let param = {
        location: localStorage.getItem("location"),
        user: userInfo.username,
      };
      this.request.post("/sign/addOrUpdate", param).then((res) => {
        if (res.success) {
          this.$message.success("打卡成功");
        } else {
          this.$message.error(res.msg);
        }
      });
    },
    open2() {
      this.$notify.info({
        title: '提示',
        message: '这是一条不会自动关闭的消息',
        duration: 0
      });
    }

  },
}
</script>

<style>
.el-carousel__container{
  height: 20vh;
}
.el-carousel__item h3 {
  color: #475669;
  font-size: 18px;
  opacity: 0.75;
  line-height: 20vh;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n+1) {
  background-color: #d3dce6;
}

.main .sign{
    width: 100px;
    height: 100px;
    border-radius: 50%;
    background: #1890ff;
    display: flex;
    align-items: center;
    justify-content: center;
    color: #fff;
    font-size: 25px;
    cursor: pointer;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.4);
}
.text {
  font-size: 14px;
}

.item {
  margin-bottom: 18px;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}
.clearfix:after {
  clear: both
}

.box-card {
  width: 100%;
  text-align: left;
  margin-bottom: 15px;
}
</style>