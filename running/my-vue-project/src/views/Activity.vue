<template>
  <div>
    <el-page-header @back="goBack" content="我的活动" style="height: 5vh;line-height: 5vh;padding-left: 10px">
    </el-page-header>
    <el-main style="display: flex;flex-direction: column">
      <el-card class="box-card" shadow="always"  v-for="activity in activities" :key="activity.id" style="margin-bottom: 20px">
        <div slot="header" class="clearfix" style="font-size: 22px">
          <span>{{ activity.name }}</span>
          <el-popover
              placement="right"
              width="400"
              trigger="click">
            <el-input
                type="textarea"
                placeholder="请输入内容"
                v-model="textarea"
                maxlength="100"
                show-word-limit
            >
            </el-input>
            <div style="margin: 20px 0 0 0"></div>
            <div>
              <el-button type="primary" style="float: right" @click="submitComment(activity.id)">提交</el-button>
            </div>
            <el-button slot="reference" style="float: right; padding: 10px" type="primary">评论</el-button>
          </el-popover>
        </div>
        <div v-for="(value,key,index) in activity" :key="index" class="text item" v-if="key!='id'&&key!='name'">
          {{ key + '：' + value }}
        </div>
      </el-card>

    </el-main>
  </div>

</template>

<script>
export default {
  name: "Activity",
  data(){
    return{
      textarea:'',
      activities:[
        {
          id:1,
          name:'hhh',
          time:Date(),
          zone:'活动区域',
          content:'活动内容'
        },
        {
          id:2,
          name: 'activity2',
          time:Date(),
          zone:'活动区域',
          content:'活动内容'
        }
      ]
    }
  },
  methods:{
    submitComment(activity_id){
      if (this.textarea.length<=5){

      }
    //   activity_id作为插入数据的参数

    },
    goBack(){
      this.$router.go(-1);
    }
  }
}
</script>

<style scoped>
.text {
  font-size: 18px;
}

.item {
  margin-bottom: 18px;
  text-align: left;
}
.clearfix{
  text-align: left;
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
}
</style>