import React from 'react';
import { BooleanInput, Create, SimpleForm, TextInput, ImageInput, ImageField } from 'react-admin';

const UserCreate = (props) => (
    <Create {...props}>
        <SimpleForm>
            <TextInput source="email" />
            <TextInput source="password" />
            <TextInput source="fullName" />
            <TextInput source="dob" />
            <TextInput source="title" />
            <TextInput source="phone" />
            <TextInput source="address" />
            <BooleanInput source="active" />

            <ImageInput source="avatar" label="Avatar" accept="image/*" placeholder={<p>Tải hình ảnh</p>}>
                <ImageField source="src" title="title" />
            </ImageInput>
        </SimpleForm>
    </Create>
);

export default UserCreate;