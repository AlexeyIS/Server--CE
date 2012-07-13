class CreateHomes < ActiveRecord::Migration
  def change
    create_table :homes do |t|
      t.string :id
      t.string :name

      t.timestamps
    end
  end
end
