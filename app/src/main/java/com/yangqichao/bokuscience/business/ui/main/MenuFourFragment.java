package com.yangqichao.bokuscience.business.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yangqichao.bokuscience.R;
import com.yangqichao.bokuscience.business.bean.LoginBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class MenuFourFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    Unbinder unbinder;
    @BindView(R.id.img_function_2)
    ImageView imgFunction2;
    @BindView(R.id.img_function_3)
    ImageView imgFunction3;
    @BindView(R.id.img_function_4)
    ImageView imgFunction4;
    @BindView(R.id.img_function_1)
    ImageView imgFunction1;
    @BindView(R.id.textView)
    TextView tvFunction4;
    @BindView(R.id.tv_function_2)
    TextView tvFunction2;
    @BindView(R.id.tv_function_3)
    TextView tvFunction3;
    @BindView(R.id.tv_function_1)
    TextView tvFunction1;

    private LoginBean mParam1;
    private LoginBean.ModuleDTOSBean module1, module2, module3, module4;

    public MenuFourFragment() {
        // Required empty public constructor
    }

    public static MenuFourFragment newInstance(LoginBean param1) {
        MenuFourFragment fragment = new MenuFourFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = (LoginBean) getArguments().getSerializable(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_four, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        module1 = mParam1.getModuleDTOSUser().get(0);
        module2 = mParam1.getModuleDTOSUser().get(1);
        module3 = mParam1.getModuleDTOSUser().get(2);
        module4 = mParam1.getModuleDTOSUser().get(3);
        tvFunction1.setText(module1.getName());
        tvFunction2.setText(module2.getName());
        tvFunction3.setText(module3.getName());
        tvFunction4.setText(module4.getName());

        if(!TextUtils.isEmpty(module1.getImgUrl())&&!ShowMenuUtil.isMainFuncation(module1.getCode())){
            Glide.with(getActivity()).load(module1.getImgUrl()).into(imgFunction1);
        }else{
            imgFunction1.setImageResource(ShowMenuUtil.getImage(module1.getCode()));
        }
        if(!TextUtils.isEmpty(module2.getImgUrl())&&!ShowMenuUtil.isMainFuncation(module2.getCode())){
            Glide.with(getActivity()).load(module2.getImgUrl()).into(imgFunction2);
        }else{
            imgFunction2.setImageResource(ShowMenuUtil.getImage(module2.getCode()));
        }
        if(!TextUtils.isEmpty(module3.getImgUrl())&&!ShowMenuUtil.isMainFuncation(module3.getCode())){
            Glide.with(getActivity()).load(module3.getImgUrl()).into(imgFunction3);
        }else{
            imgFunction3.setImageResource(ShowMenuUtil.getImage(module3.getCode()));
        }
        if(!TextUtils.isEmpty(module4.getImgUrl())&&!ShowMenuUtil.isMainFuncation(module4.getCode())){
            Glide.with(getActivity()).load(module4.getImgUrl()).into(imgFunction4);
        }else{
            imgFunction4.setImageResource(ShowMenuUtil.getImage(module4.getCode()));
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.img_function_2, R.id.img_function_3, R.id.img_function_4, R.id.img_function_1})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_function_2:
                startActivity(ShowMenuUtil.getClass(getActivity(),module2));
                break;
            case R.id.img_function_3:
                startActivity(ShowMenuUtil.getClass(getActivity(),module3));
                break;
            case R.id.img_function_4:
                startActivity(ShowMenuUtil.getClass(getActivity(),module4));
                break;
            case R.id.img_function_1:
                startActivity(ShowMenuUtil.getClass(getActivity(),module1));
                break;
        }
    }
}
