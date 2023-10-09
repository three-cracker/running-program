<!--:value="activity.comment==null?'':activity.comment.content"-->
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
                :v-model="textarea"
                value=""
                maxlength="100"
                show-word-limit
            >
            </el-input>
            <div style="margin: 20px 0 0 0"></div>
            <div>
              <el-button type="primary" style="float: right" @click="submitComment(activity)">提交</el-button>
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
import axios from "axios";

export default {
  name: "Activity",
  data(){
    return{
      user:localStorage.getItem("current-user") ? JSON.parse(localStorage.getItem("current-user")) : {},
      textarea:'',
      activity_ids:[],
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
  created() {

  //   通过user_id查找activity_id来查找activities
    axios.get('http://localhost:8081/user/activity/' + this.user.id,
        {
          headers:{
            'Content-Type':'application/json'
          }
        }).then(res=>{
        if (res.data.code===1){
          console.log(res.data)
        }
        else{
          console.log(res.data)
        }
    })
  },
  methods:{
    submitComment(activity){
      if (activity.comment==null&&this.textarea!=''){
      //   增加comment，并提示增加积分0.5
      //   更新comment表
        axios.put('http://localhost:8081/',
            {
              activity_id:activity.id,
              user_id:this.user.id,
              content:activity.comment.content
            },
            {
              headers:{
                'Content-Type':'application/json'
              }
            }).then(res=>{
          if (res.data.code===1){
          //   更新activity表

          }
          else{
            console.log(res.data)
          }
        })
      }
      else if (activity.comment!=null&&this.textarea!=''){
      //   更新comment，并提示修改成功
        axios.put('http://localhost:8081/',
            {
              activity_id:activity.id,
              user_id:this.user.id,
              content:activity.comment.content
            },
            {
              headers:{
                'Content-Type':'application/json'
              }
            }).then(res=>{
          if (res.data.code===1){
            //   更新activity表
          }
          else{
            console.log(res.data)
          }
        })
      }
      else if (this.textarea==''){
      //   提示提交的评论不能为空
        this.$notify.info("评论不能为空!")
      }
    //通过user_id和activity_id来查找是否有该comment

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