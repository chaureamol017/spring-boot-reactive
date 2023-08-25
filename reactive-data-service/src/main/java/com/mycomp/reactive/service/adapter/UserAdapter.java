package com.mycomp.reactive.service.adapter;

import com.mycomp.reactive.common.adapter.ModelAdapter;
import com.mycomp.reactive.persistence.entity.User;
import com.mycomp.reactive.service.model.UserModel;

public final class UserAdapter implements ModelAdapter<User, UserModel> {
    public static final UserAdapter INSTANCE = new UserAdapter();

    private UserAdapter() {
    }

    @Override
    public User toEntityMinimal(UserModel model) {
        return new User(null, model.getName());
    }

    @Override
    public User toEntity(UserModel model) {
        return new User(model.getUserId(), model.getName());
    }

    @Override
    public UserModel toModel(User user) {
        return new UserModel(user.getUserId(), user.getName());
    }
}
