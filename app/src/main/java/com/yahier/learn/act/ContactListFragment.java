package com.yahier.learn.act;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.hyphenate.chat.EMClient;
import com.hyphenate.easeui.domain.EaseUser;
import com.hyphenate.easeui.ui.EaseContactListFragment;
import com.hyphenate.util.EMLog;
import com.hyphenate.util.NetUtils;
import com.yahier.learn.R;

import java.util.Hashtable;
import java.util.Map;


import com.hyphenate.chat.EMClient;
//import com.hyphenate.chatuidemo.DemoHelper;
//import com.hyphenate.chatuidemo.DemoHelper.DataSyncListener;
//import com.hyphenate.chatuidemo.db.InviteMessgeDao;
//import com.hyphenate.chatuidemo.db.UserDao;
import com.hyphenate.easeui.domain.EaseUser;
import com.hyphenate.easeui.ui.EaseContactListFragment;
import com.hyphenate.util.EMLog;
import com.hyphenate.util.NetUtils;
import com.yahier.learn.widget.ContactItemView;

/**
 * Created by Administrator on 2016/10/31.
 */

public class ContactListFragment extends EaseContactListFragment {

   // private static final String TAG = ContactListFragment.class.getSimpleName();
  //  private ContactSyncListener contactSyncListener;
   // private BlackListSyncListener blackListSyncListener;
   // private ContactInfoSyncListener contactInfoSyncListener;
    private View loadingView;
    private ContactItemView applicationItem;
   // private InviteMessgeDao inviteMessgeDao;

    @SuppressLint ("InflateParams")
    @Override
    protected void initView() {
        super.initView();
        @SuppressLint("InflateParams") View headerView = LayoutInflater.from(getActivity()).inflate(R.layout.em_contacts_header, null);
        HeaderItemClickListener clickListener = new HeaderItemClickListener();
        applicationItem = (ContactItemView) headerView.findViewById(R.id.application_item);
        applicationItem.setOnClickListener(clickListener);
        headerView.findViewById(R.id.group_item).setOnClickListener(clickListener);
        headerView.findViewById(R.id.chat_room_item).setOnClickListener(clickListener);
        headerView.findViewById(R.id.robot_item).setOnClickListener(clickListener);
        listView.addHeaderView(headerView);
        //add loading view
        loadingView = LayoutInflater.from(getActivity()).inflate(R.layout.em_layout_loading_data, null);
        contentContainer.addView(loadingView);

        registerForContextMenu(listView);
    }

    @Override
    public void refresh() {
//        Map<String, EaseUser> m = DemoHelper.getInstance().getContactList();
//        if (m instanceof Hashtable<?, ?>) {
//            m = (Map<String, EaseUser>) ((Hashtable<String, EaseUser>)m).clone();
//        }
//        setContactsMap(m);
//        super.refresh();
//        if(inviteMessgeDao == null){
//            inviteMessgeDao = new InviteMessgeDao(getActivity());
//        }
//        if(inviteMessgeDao.getUnreadMessagesCount() > 0){
//            applicationItem.showUnreadMsgView();
//        }else{
//            applicationItem.hideUnreadMsgView();
//        }
    }


    @SuppressWarnings("unchecked")
    @Override
    protected void setUpView() {
        titleBar.setRightImageResource(R.mipmap.em_add);
        titleBar.setRightLayoutClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                startActivity(new Intent(getActivity(), AddContactActivity.class));
                NetUtils.hasDataConnection(getActivity());
            }
        });
        //设置联系人数据
//        Map<String, EaseUser> m = DemoHelper.getInstance().getContactList();
//        if (m instanceof Hashtable<?, ?>) {
//            m = (Map<String, EaseUser>) ((Hashtable<String, EaseUser>)m).clone();
//        }
//        setContactsMap(m);
        super.setUpView();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                EaseUser user = (EaseUser)listView.getItemAtPosition(position);
                if (user != null) {
                    String username = user.getUsername();
                    // demo中直接进入聊天页面，实际一般是进入用户详情页
                   // startActivity(new Intent(getActivity(), ChatActivity.class).putExtra("userId", username));
                }
            }
        });


        // 进入添加好友页
        titleBar.getRightLayout().setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
               // startActivity(new Intent(getActivity(), AddContactActivity.class));
            }
        });


//        contactSyncListener = new ContactSyncListener();
//        DemoHelper.getInstance().addSyncContactListener(contactSyncListener);
//
//        blackListSyncListener = new BlackListSyncListener();
//        DemoHelper.getInstance().addSyncBlackListListener(blackListSyncListener);
//
//        contactInfoSyncListener = new ContactInfoSyncListener();
//        DemoHelper.getInstance().getUserProfileManager().addSyncContactInfoListener(contactInfoSyncListener);
//
//        if (DemoHelper.getInstance().isContactsSyncedWithServer()) {
//            loadingView.setVisibility(View.GONE);
//        } else if (DemoHelper.getInstance().isSyncingContactsWithServer()) {
//            loadingView.setVisibility(View.VISIBLE);
//        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        if (contactSyncListener != null) {
//            DemoHelper.getInstance().removeSyncContactListener(contactSyncListener);
//            contactSyncListener = null;
//        }
//
//        if(blackListSyncListener != null){
//            DemoHelper.getInstance().removeSyncBlackListListener(blackListSyncListener);
//        }
//
//        if(contactInfoSyncListener != null){
//            DemoHelper.getInstance().getUserProfileManager().removeSyncContactInfoListener(contactInfoSyncListener);
//        }
    }


    protected class HeaderItemClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.application_item:
                    // 进入申请与通知页面
                   // startActivity(new Intent(getActivity(), NewFriendsMsgActivity.class));
                    break;
                case R.id.group_item:
                    // 进入群聊列表页面
                   // startActivity(new Intent(getActivity(), GroupsActivity.class));
                    break;
                case R.id.chat_room_item:
                    //进入聊天室列表页面
                   // startActivity(new Intent(getActivity(), PublicChatRoomsActivity.class));
                    break;
                case R.id.robot_item:
                    //进入Robot列表页面
                   // startActivity(new Intent(getActivity(), RobotsActivity.class));
                    break;

                default:
                    break;
            }
        }

    }


//    @Override
//    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//        super.onCreateContextMenu(menu, v, menuInfo);
//        toBeProcessUser = (EaseUser) listView.getItemAtPosition(((AdapterView.AdapterContextMenuInfo) menuInfo).position);
//        toBeProcessUsername = toBeProcessUser.getUsername();
//        getActivity().getMenuInflater().inflate(R.menu.em_context_contact_list, menu);
//    }
//
//    @Override
//    public boolean onContextItemSelected(MenuItem item) {
//        if (item.getItemId() == R.id.delete_contact) {
//            try {
//                // delete contact
//                // remove invitation message
//                InviteMessgeDao dao = new InviteMessgeDao(getActivity());
//                dao.deleteMessage(toBeProcessUser.getUsername());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            return true;
//        }else if(item.getItemId() == R.id.add_to_blacklist){
//            moveToBlacklist(toBeProcessUsername);
//            return true;
//        }
//        return super.onContextItemSelected(item);
//    }


    }
//
//    class ContactSyncListener implements DataSyncListener{
//        @Override
//        public void onSyncComplete(final boolean success) {
//            EMLog.d(TAG, "on contact list sync success:" + success);
//            getActivity().runOnUiThread(new Runnable() {
//                public void run() {
//                    getActivity().runOnUiThread(new Runnable(){
//
//                        @Override
//                        public void run() {
//                            if(success){
//                                loadingView.setVisibility(View.GONE);
//                                refresh();
//                            }else{
//                                String s1 = getResources().getString(R.string.get_failed_please_check);
//                                Toast.makeText(getActivity(), s1, Toast.LENGTH_LONG).show();
//                                loadingView.setVisibility(View.GONE);
//                            }
//                        }
//
//                    });
//                }
//            });
//        }
//    }

//    class BlackListSyncListener implements DataSyncListener{
//
//        @Override
//        public void onSyncComplete(boolean success) {
//            getActivity().runOnUiThread(new Runnable(){
//
//                @Override
//                public void run() {
//                    refresh();
//                }
//            });
//        }
//
//    }
//
//    class ContactInfoSyncListener implements DataSyncListener{
//
//        @Override
//        public void onSyncComplete(final boolean success) {
//            EMLog.d(TAG, "on contactinfo list sync success:" + success);
//            getActivity().runOnUiThread(new Runnable() {
//
//                @Override
//                public void run() {
//                    loadingView.setVisibility(View.GONE);
//                    if(success){
//                        refresh();
//                    }
//                }
//            });
//        }
//
//    }

//}
